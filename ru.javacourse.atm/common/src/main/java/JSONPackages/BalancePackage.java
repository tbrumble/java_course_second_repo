package JSONPackages;


import DTO.BalanceDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalancePackage {
    public BalancePackage() {}
    private BalanceDTO balanceDTO;
    private String clientHash;
}
