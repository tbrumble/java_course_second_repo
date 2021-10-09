package businesslogic.bank.balance;

import java.math.BigDecimal;

public class NegativeBalance extends Balance{
    public NegativeBalance(BigDecimal sum, String isoCode) {
        super(sum, isoCode);
    }
}
