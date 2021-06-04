package JSONPackages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardPackage {
    private String number;
    private String pinHash;
    private String cvcHash;

    @Override
    public String toString(){
        return String.format("CardPackage{Номер:%s, Хеш пина:%s, Хеш cvc:%s}", number, pinHash, cvcHash);
    }
}
