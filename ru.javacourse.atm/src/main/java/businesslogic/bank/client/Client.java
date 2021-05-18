package businesslogic.bank.client;

import businesslogic.bank.account.Account;
import businesslogic.bank.balance.Balance;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Client<T extends Balance> {
    @Getter
    @Setter
    private String number;
    @Setter
    @Getter
    private List<Account<T>> accounts;

    public Account<T> getAccountByNum(String number) {
        Optional<Account<T>> account = accounts.stream().filter(
                account1 -> account1.getCardByNum(number)
        ).findFirst();

        if (account.isPresent()) {
            return account.get();
        } else {
            return null;
        }
    }
}
