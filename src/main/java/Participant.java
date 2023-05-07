import java.util.ArrayList;
import java.util.List;

public abstract class Participant {

  //ここでシングルトンのインスタンスを呼び出しているが、継承しているクラスではdeckがあるのかどうかわかりづらい気もする
  Deck deck = Deck.getInstance();

  String name;
  int point;
  List<Card> hand;

  public Participant() {
    this.point = 0;
    this.hand = new ArrayList<>();
  }

  protected abstract void drawCard();

  protected abstract void getStartingHand();

  protected abstract void getAdditionalCard();

  public boolean checkPoints() {
    if (point > 21) {
      System.out.println("Busted!! " + this.name + "の負け");
      return true;
    }
    return false;
  }

}
