import java.util.Scanner;

public class Player extends Participant {

  public Player() {
    super();
    this.name = "プレイヤー";
    System.out.println(this.name + "の初期の手札を配ります..");
    drawCard();
    drawCard();

  }

  @Override
  protected void drawCard() {
    var dealtCard = deck.drawCard();
    this.hand.add(dealtCard);
    this.point += dealtCard.getPoint();
    System.out.println(
        this.name + "の引いた" + hand.size() + "枚目のカードは" + dealtCard.getSuit().getName() + "の"
            + dealtCard.toDisplayValue());
    checkPoints();

    //手札の合計値の表示
    if (hand.size() > 1) {
      System.out.println(this.name + "の合計値は" + this.point);
    }
  }

  @Override
  protected void getAdditionalCard() {
    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (!input.equals("no")) {
      System.out.print("カードを引き続き引きますか? (yes/no) ");
      input = scanner.nextLine();
      if (input.equals("yes")) {
        // 続行する処理を記述する
        drawCard();
      } else if (!input.equals("no")) {
        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
      }
    }
  }


}
