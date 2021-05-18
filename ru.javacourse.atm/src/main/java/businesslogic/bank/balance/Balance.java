package businesslogic.bank.balance;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import java.math.BigDecimal;

public class Balance {
    @Getter
    private BigDecimal sum;
    @Getter
    private final String isoCode;

    public Balance(@NotNull BigDecimal sum, @NotNull String isoCode){
        this.isoCode = isoCode;
        this.sum = sum;
    }

    public void setSum(BigDecimal sum) throws Exception {
        this.sum = sum;
    }
}
