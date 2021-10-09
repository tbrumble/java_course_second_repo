package businesslogic.bank.card;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class Card {
    private String number;
    private LocalDate expireDate;
    private String pinHash;
    private String cvcHash;
    @Override
    public String toString() {
        return "Номер:" + number
                + " Действительна до:" + expireDate.toString()
                + " Pin hash:" + pinHash
                + " Cvc hash:" + cvcHash;
    }
}
