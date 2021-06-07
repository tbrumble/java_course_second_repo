package JSONPackages;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CardPackage {
    private String number;
    private String pinHash;
    private String cvcHash;
    private String cardIdHash;

    public CardPackage() {

    }

    @Override
    public String toString(){
        return String.format("CardPackage{Номер:%s, Хеш пина:%s, Хеш cvc:%s; Хеш в системе:%s}", number, pinHash, cvcHash, cardIdHash);
    }
}
