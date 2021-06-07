package ru.javacourse.atm.external.bank.api.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account", schema = "api")
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountid")
    private Long accountid;

    @Column(name = "accountnumber")
    private String number;

    @Column(name = "accountbalance", precision=18, scale=2)
    private BigDecimal balance;

    @Column(name = "accountisocode")
    private String isoCode;

    @Column(name = "cardid")
    private Long cardid;
}
