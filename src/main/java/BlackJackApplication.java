import java.util.Scanner;

public class BlackJackApplication {

  public static void main(String[] args) {
    gameLoop();
    System.out.println("Exiting...");
    System.exit(0);
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

    ///TODO 17以下ならdealerは引き続けるというのはドメイン(今回のゲームのルール)なので,gameの中で書くべき
    while(dealer.point < 17) {


    }

    // playerのBust判定
    if (!player.isBust()) {
      //dealerの追加のカードを引く
      dealer.getAdditionalCard();
      // dealerのBust判定
      if (!dealer.isBust()) {
        // 勝敗のチェック
        checkWinner(player, dealer);
      }
    }
  }

  //ここの再帰関数だとGCがされず、playerとかdealerが生成されまくるので.別の方法を考える　gameのcallがスタック
  //whileのスコープ内でgameを呼び出すようにする
  //末尾再帰だけはおっけ
  public static void gameLoop() {
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
  }

  //TODO このcheckWinnerは二つの処理を行っている winnerのチェックと, その結果の表示 結果の表示はcheck自体とは関係がないので、別のメソッドに書くべき
  private static void checkWinner(Player player, Dealer dealer) {
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
