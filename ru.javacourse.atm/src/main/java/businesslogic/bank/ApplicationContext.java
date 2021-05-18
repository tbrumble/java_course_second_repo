package businesslogic.bank;

import businesslogic.bank.account.Account;
import businesslogic.bank.balance.NegativeBalance;
import businesslogic.bank.card.Card;
import businesslogic.bank.client.Client;

import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс для тестового заполнения данными для работы банкомата
 * Будет переделан при пеерезде на spring
 */

import java.security.MessageDigest;

public class ApplicationContext {
    @NonNull
    @Getter
    private Client client;
    @NonNull
    @Getter
    private Card pinCard;

    private ApplicationContext instance;

    public ApplicationContext getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public String getStringHash(String stringHash) {
        MessageDigest messageDigest;
        String resultHash = "";
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(stringHash.getBytes());
            resultHash = new String(messageDigest.digest(), StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return resultHash;
    }


    /**
     * Тестовый метод для домашнего задания 10
     * Заполнение счетов, карт и баланса для тестирования
     */
    public void fillTestData() {

        Account<NegativeBalance> account = new Account<>();
        account.addCard(
                new Card().setCvcHash(getStringHash("123"))
                        .setPinHash(getStringHash("999"))
                        .setExpireDate(LocalDate.now())
                        .setNumber("4081781012345671")
        );
        account.addCard(
                new Card().setCvcHash(getStringHash("016"))
                        .setPinHash(getStringHash("312"))
                        .setExpireDate(LocalDate.of(2031, 12, 11))
                        .setNumber("0312264371234567")
        );
        account.setNumber("42103840280091231312");
        BigDecimal bigDecimal = new BigDecimal(-146.14).setScale(2, BigDecimal.ROUND_HALF_UP);
        account.setBalance(new NegativeBalance(bigDecimal, "RUB"));

        List<Account<NegativeBalance>> accounts = new ArrayList<>();
        accounts.add(account);

        client = new Client<NegativeBalance>();
        client.setAccounts(accounts);

        pinCard = new Card().setCvcHash(getStringHash("016"))
                .setPinHash(getStringHash("312"))
                .setExpireDate(LocalDate.of(2031, 12, 11))
                .setNumber("0312264371234567");
    }
}
