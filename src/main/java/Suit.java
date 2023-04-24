public enum Suit {
  SPADE("スペード"),
  CLUB("クラブ"),
  HEART("ハート"),
  DIAMOND("ダイヤモンド");

  private final String name;

  Suit(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
