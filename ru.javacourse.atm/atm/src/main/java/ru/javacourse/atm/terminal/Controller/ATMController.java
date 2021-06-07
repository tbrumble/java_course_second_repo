package ru.javacourse.atm.terminal.Controller;

import JSONPackages.BalancePackage;
import JSONPackages.CardPackage;
import JSONPackages.VerifyPackage;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.javacourse.atm.terminal.Exceptions.*;

import java.util.Objects;

@RestController
@AllArgsConstructor
public class ATMController {
    private static final String VERIFY_CARD_ADDRESS = "http://localhost:9091/verifycard";
    private static final String BALANCE_CARD_ADDRESS = "http://localhost:9091/getbalance/clienthash/";


    @GetMapping("/getbalance/cardpin/{cardpin}/cardcvc/{cardcvc}/cardnumber/{cardnumber}")
    public String getBalance(@PathVariable("cardpin") String cardPin,
                               @PathVariable("cardcvc") String cardCvc,
                               @PathVariable("cardnumber") String cardNumber) {

        if (cardPin.isEmpty() || cardCvc.isEmpty() || cardNumber.isEmpty()) {
            throw new ATMVerifyCardException("Bad input data");
        }

        //отправка запроса для валидации карты и отправка получения запроса, если валилация прошла
        try {
            String cardHashId = sendVerifyCardRequest(cardPin, cardCvc, cardNumber);
            if (!cardHashId.isEmpty()) {
                return sendBalanceRequest(cardHashId);
            }
        } catch (Exception e) {
            throw new ATMBalanceException("sendBalanceRequest error");
        }
        return "";
    }

    private String sendBalanceRequest(String cardHashId) throws ATMBalanceException{
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestBalancePackage = new HttpEntity<>(BALANCE_CARD_ADDRESS);
        ResponseEntity<BalancePackage> responseBalancePackage = restTemplate.
                postForEntity(
                        BALANCE_CARD_ADDRESS + cardHashId,
                        requestBalancePackage,
                        BalancePackage.class);


        if (responseBalancePackage.hasBody() && !(Objects.requireNonNull(responseBalancePackage.getBody()).getBalanceDTO() == null)) {
           return Objects.requireNonNull(responseBalancePackage.getBody().getBalanceDTO().toString());
        }
        return "";
    }

    private HttpEntity<CardPackage> getCardPackageHttpEntity(String cardPin, String cardCvc, String cardNumber) {
        return new HttpEntity<>(
                new CardPackage()
                        .setNumber(cardNumber)
                        .setCvcHash(cardCvc)
                        .setPinHash(cardPin)
                );
    }

    private String sendVerifyCardRequest(String cardPin, String cardCvc, String cardNumber) throws ATMVerifyCardException{
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CardPackage> requestCardPackage = getCardPackageHttpEntity(cardPin, cardCvc, cardNumber);
        ResponseEntity<VerifyPackage> responseVerifyPackage = restTemplate.
                postForEntity(VERIFY_CARD_ADDRESS, requestCardPackage, VerifyPackage.class);
        if (responseVerifyPackage.hasBody()
                && Objects.requireNonNull(responseVerifyPackage.getBody()).isResult()) {
            return responseVerifyPackage.getBody().getCardPackage().getCardIdHash();
        }
        return "";
    }
}
