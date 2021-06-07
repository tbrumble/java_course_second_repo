package ru.javacourse.atm.external.bank.api.Controller;

import JSONPackages.CardPackage;
import JSONPackages.VerifyPackage;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.javacourse.atm.external.bank.api.Exceptions.CardVerifierException;
import ru.javacourse.atm.external.bank.api.Service.CardService;

@RestController
@AllArgsConstructor
public class CardVerifierController {
    private CardService cardService;

    @PostMapping(value = "/verifycard", consumes = MediaType.APPLICATION_JSON_VALUE)
    public VerifyPackage verifyCard(@RequestBody CardPackage cardPackage){
        VerifyPackage verifyPackage = new VerifyPackage(cardPackage);
        try{
            if (cardService.verifyCard(cardPackage)) {
                verifyPackage.setResult(Boolean.TRUE);
            }
        } catch (Exception e)
        {
            throw new CardVerifierException("Bad request");
        }
        return verifyPackage;
    }
}
