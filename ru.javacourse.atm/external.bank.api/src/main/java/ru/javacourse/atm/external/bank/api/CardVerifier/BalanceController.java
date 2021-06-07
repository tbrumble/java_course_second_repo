package ru.javacourse.atm.external.bank.api.CardVerifier;

import JSONPackages.BalancePackage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.javacourse.atm.external.bank.api.Exceptions.BalanceException;
import ru.javacourse.atm.external.bank.api.Service.AccountService;
import ru.javacourse.atm.external.bank.api.Service.ClientService;


@RestController
@AllArgsConstructor
public class BalanceController {
    private AccountService accountService;
    private ClientService clientService;

    @GetMapping(value = "/getbalance/clienthash/{clienthash}")
    public BalancePackage getBalance(@PathVariable("clienthash") String clienthash){
        BalancePackage balancePackage  = new BalancePackage();
        balancePackage.setClientHash(clienthash);
        try{
            balancePackage.setBalanceDTO(
                    accountService.getBalance(
                            clientService.getAccountId(clienthash),
                            clienthash
                    )
            );
        } catch (Exception e)
        {
            throw new BalanceException("Bad request");
        }
        return balancePackage;
    }

}
