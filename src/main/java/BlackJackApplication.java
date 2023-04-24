import java.util.Scanner;

public class BlackJackApplication {

  public static void main(String[] args) {
    game();
  }

  //ゲームの中身
  private static void game() {
    //ここにgameの基本的な進行に関するルールのことを書く

    //プレイヤーの生成
    var player = new Player();
    var dealer = new Dealer();

    //v
    player.getStartingHand();
    dealer.getStartingHand();

    //追加のカードを引く
    player.getAdditionalCard();
    dealer.getAdditionalCard();

    //勝敗のチェック
    gameChecker(player, dealer);
    continueBlackJack();
  }

//ここの再帰関数だとGCがされず、playerとかdealerが生成されまくるので.別の方法を考える
  public static void continueBlackJack() {
    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (!input.equals("no")) {
      System.out.print("もう一度プレイしますか? (yes/no) ");
      input = scanner.nextLine();
      if (input.equals("yes")) {
        game();
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
