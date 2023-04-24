import static java.lang.String.valueOf;

public class Card {

  private final Suit suit;
  private final int rank;
  private final int point;

  public Suit getSuit() {
    return suit;
  }

  public int getPoint() {
    return point;
  }

  public Card(Suit suit, int rank) {
    this.suit = suit;
    this.rank = rank;
    this.point = setPoint();
  }

  public String toDisplayValue() {
    switch (this.rank) {
      case 1:
        return "A";
      case 11:
        return "J";
      case 12:
        return "Q";
      case 13:
        return "K";
    }
    return valueOf(this.point);
  }

  public int setPoint() {
    if (this.rank > 10) {
      return 10;
    }
    return this.rank;
  }


}
