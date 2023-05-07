import java.util.Scanner;

public class BlackJackApplication {

  public static void main(String[] args) {
    startGame();
  }

  //ゲームの中身
  private static void game() {
    //ここにgameの基本的な進行に関するルールのことを書く
    //プレイヤーの生成
    var player = new Player();
    var dealer = new Dealer();

    //初期手札を引く
    player.getStartingHand();
    dealer.getStartingHand();

    //playerの追加のカードを引く
    player.getAdditionalCard();


    // playerのBust判定
    var isPlayerBusted = player.checkPoints();
    if (!isPlayerBusted) {
      //dealerの追加のカードを引く
      dealer.getAdditionalCard();
      // dealerのBust判定
      var isDealerBusted = dealer.checkPoints();

      if (!isDealerBusted) {
        // 勝敗のチェック
        gameChecker(player, dealer);
      }
    }
  }

  //ここの再帰関数だとGCがされず、playerとかdealerが生成されまくるので.別の方法を考える　gameのcallがスタック
  //whileのスコープ内でgameを呼び出すようにする
  public static void startGame() {
    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (!input.equals("no")) {
      game();

      System.out.print("もう一度プレイしますか? (yes/no) ");
      input = scanner.nextLine();
      while (!input.equals("yes") && !input.equals("no")) {
        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        System.out.print("もう一度プレイしますか? (yes/no) ");
        input = scanner.nextLine();
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
