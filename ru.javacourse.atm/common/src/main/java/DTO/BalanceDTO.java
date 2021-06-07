package DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BalanceDTO {
    private final String balance;
    private final String isoCode;
}
