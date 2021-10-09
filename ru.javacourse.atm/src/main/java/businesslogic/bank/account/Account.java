package businesslogic.bank.account;


import businesslogic.bank.balance.Balance;
import businesslogic.bank.card.Card;
import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Account <T extends Balance>{
    @Getter
    @Setter
    private String number;
    @Getter
    @Setter
    private T balance;
    @Getter
    private final List<Card> cards = new ArrayList<>();

    public Boolean getCardByNum(String number) {
        Optional<Card> card = cards.stream().filter(
                card1 -> card1.getNumber().equals(number)).findFirst();
        return card.isPresent();
    }

    public boolean addCard(@NotNull Card card) {
        Optional<Card> filteredCard = cards.stream().filter(card1 -> card1.getNumber().equals(card.getNumber())).findFirst();
        if (filteredCard.isPresent()) {
            return Boolean.FALSE;
        } else {
            return cards.add(card);
        }
    }


}
