package ru.javacourse.atm.external.bank.api.Service;

import JSONPackages.CardPackage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javacourse.atm.external.bank.api.Entity.Card;
import ru.javacourse.atm.external.bank.api.Repository.CardRepository;

import java.time.Instant;
import java.util.Date;

@Service
@AllArgsConstructor
public class CardService {
    private CardRepository cardRepository;

    private boolean verifyDate(Date expireDate){
        return expireDate.before(
                Date.from(Instant.now())
        );
    }

    public boolean verifyCard(CardPackage cardPackage) {
        boolean resultValue = Boolean.FALSE;
        Iterable<Card> cardIterable = cardRepository.findAll();
        for (Card card: cardIterable) {
            if (card.getCardNumber().equals(cardPackage.getNumber())
                    && card.getCvcPinHash().equals(cardPackage.getCvcHash())
                    && card.getCardPinHash().equals(cardPackage.getPinHash())
                    && !card.isBlocked() && verifyDate(card.getExpireDate())) {
                resultValue = Boolean.TRUE;
                break;
            }
        }
        return resultValue;
    }
}
