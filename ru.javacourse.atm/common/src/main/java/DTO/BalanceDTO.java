package DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceDTO {
    private String balance;
    private String isoCode;

    @Override
    public String toString(){
        return String.format("Баланс: %s, Валюта: %s", balance, isoCode);
    }

    public BalanceDTO() {}
    public BalanceDTO(String balance, String isoCode) {
        this.balance = balance;
        this.isoCode = isoCode;
    }
}
