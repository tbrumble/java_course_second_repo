package businesslogic.bank.balance;

import java.math.BigDecimal;

public class PositiveBalance extends Balance {
    public static final String EXCEPTION_MESSAGE = "Баланс не может быть отрицательным";

    @Override
    public void setSum(BigDecimal sum) throws Exception{
        if (sum.compareTo(BigDecimal.ZERO) == -1) {
            throw new NegativeBalanceException(EXCEPTION_MESSAGE);
        }
        super.setSum(sum);
    }

    public PositiveBalance(BigDecimal sum, String isoCode) {
        super(sum, isoCode);
    }
}
