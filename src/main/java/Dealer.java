public class Dealer extends Participant {

//  基本的にコンストラクタには初期値の操作のみを入れる
  public Dealer() {
    super();
    name = "ディーラー";
  }


  @Override
  protected void drawCard() {
    var dealtCard = deck.drawCard();
    //TODO gameRuleがgame外(dealerクラスの中)で書かれているべきではない
    if (this.hand.size() == 0) {
      System.out.println(name + "の1枚目のカードは" + dealtCard.getSuit().getName() + "の"
          + dealtCard.toDisplayValue());
    }
    this.hand.add(dealtCard);
    this.point += dealtCard.getPoint();
  }

  @Override
  protected void getStartingHand() {
    drawCard();
    drawCard();
  }

  @Override
  protected void getAdditionalCard() {
    if (this.point <= 17) {
      System.out.println(this.name + "が" + (this.hand.size() + 1) + "枚目のカードを引いています...");
      drawCard();
      getAdditionalCard();
    }
  }
}
