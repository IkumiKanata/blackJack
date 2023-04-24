public class Dealer extends Participant {

  public Dealer() {
    super();
    name = "ディーラー";
    System.out.println(this.name + "の初期の手札を配ります..");
    drawCard();
    drawCard();
  }


  @Override
  protected void drawCard() {
    var dealtCard = deck.drawCard();
    if (this.hand.size() == 0) {
      System.out.println(name + "の1枚目のカードは" + dealtCard.getSuit().getName() + "の"
          + dealtCard.toDisplayValue());
    }
    this.hand.add(dealtCard);
    this.point += dealtCard.getPoint();
    checkPoints();
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
