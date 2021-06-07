package ru.javacourse.atm.external.bank.api.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "client", schema = "api")
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clientid")
    private Long clientid;

    @Column(name = "accountid")
    private Long accountid;
}
