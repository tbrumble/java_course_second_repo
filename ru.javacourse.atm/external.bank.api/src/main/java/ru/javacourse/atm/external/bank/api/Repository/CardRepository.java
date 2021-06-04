package ru.javacourse.atm.external.bank.api.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.javacourse.atm.external.bank.api.Entity.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
}
