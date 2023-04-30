import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

  private final List<Card> cards;

  private static final Deck INSTANCE = new Deck();

  private Deck() {
    cards = new ArrayList<>();
    create();
  }

  public static Deck getInstance() {
    return INSTANCE;
  }

  private void create() {
    for (Suit suit : Suit.values()) {
      for (int rank = 1; rank <= 13; rank++) {
        var card = new Card(suit, rank);
        cards.add(card);
      }
    }
    shuffle();
  }

  private void shuffle() {
    Collections.shuffle(cards);
  }

  public Card drawCard() {
    if (cards.size() > 0) {
      return cards.remove(0);
    }
    return null;
  }
}