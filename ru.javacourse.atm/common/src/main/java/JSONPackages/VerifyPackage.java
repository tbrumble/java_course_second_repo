package JSONPackages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyPackage {
    private CardPackage cardPackage;
    private boolean result;

    public VerifyPackage() {

    }

    public VerifyPackage(CardPackage cardPackage){
        this.cardPackage = cardPackage;
        this.result = Boolean.FALSE;
    }

    @Override
    public String toString(){
        return String.format("VerifyPackage{%s, Результат:%s}", cardPackage, result);
    }
}
