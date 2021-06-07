package Service;

import JSONPackages.BalancePackage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ATMService {

    public String getString(ResponseEntity<BalancePackage> responseBalancePackage) {
        return String.format("Сумма: %s, Баланс: %s",
                responseBalancePackage.getBody().getBalanceDTO().getBalance(),
                responseBalancePackage.getBody().getBalanceDTO().getIsoCode());
    }
}
