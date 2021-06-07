package ru.javacourse.atm.external.bank.api.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card", schema = "api")
@NoArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "cardid")
    private Long cardId;

    @Column(name = "cardnumber")
    private String cardNumber;

    @Column(name = "cardpinhash")
    private String cardPinHash;

    @Column(name = "cvcpinhash")
    private String cvcPinHash;

    @Column(name = "expiredate")
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    @Column(name = "isblocked")
    private boolean isBlocked;
}
