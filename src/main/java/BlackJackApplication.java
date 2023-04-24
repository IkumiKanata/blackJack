import java.util.Scanner;

public class BlackJackApplication {

  public static void main(String[] args) {
    blackJack();
  }

  //ゲームの中身
  private static void blackJack() {
    var player = new Player();
    var dealer = new Dealer();

    player.getAdditionalCard();
    dealer.getAdditionalCard();

    gameChecker(player, dealer);
    continueBlackJack();
  }

  public static void continueBlackJack() {
    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (!input.equals("no")) {
      System.out.print("もう一度プレイしますか? (yes/no) ");
      input = scanner.nextLine();
      if (input.equals("yes")) {
        blackJack();
      } else if (!input.equals("no")) {
        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
      }
    }
    System.out.println("Exiting...");
    System.exit(0);
  }

  private static void gameChecker(Player player, Dealer dealer) {
    System.out.println("手札公開!!");
    System.out.println("プレイヤー:" + player.point);
    System.out.println("ディーラー:" + dealer.point);
    if (player.point > dealer.point) {
      System.out.println("プレイヤーの勝利");
    } else if (player.point == dealer.point) {
      System.out.println("引き分け");
    } else {
      System.out.println("ディーラーの勝利");
    }
  }
}
