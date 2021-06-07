package ru.javacourse.atm.external.bank.api.Service;

import DTO.BalanceDTO;
import Utils.HashBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javacourse.atm.external.bank.api.Entity.Account;
import ru.javacourse.atm.external.bank.api.Exceptions.NoEntityException;
import ru.javacourse.atm.external.bank.api.Repository.AccountRepository;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public BalanceDTO getBalance(String accountId, String cardId) throws NoEntityException{
        Account accountResult = accountRepository.findAll().stream()
                .filter(account ->
                        HashBuilder.getStringHash(account.getCardid().toString()).equals(cardId))
                .filter(account ->
                        account.getAccountid().toString().equals(accountId))
                .findFirst().orElseThrow(
                () -> new NoEntityException(String.format("Ошибка поиска данных в БД. AccountHash:%s, CardHash:%s", accountId, cardId))
        );
        return new BalanceDTO(
                accountResult.getBalance().toString(),
                accountResult.getIsoCode()
        );
    }
}
