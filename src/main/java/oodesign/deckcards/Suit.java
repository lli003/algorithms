package oodesign.deckcards;

public enum Suit {
  
  Club(0), Diamond(1), Heart(2), Spade(3);
  
  private int value;
  
  private Suit(int x) {value = x;}
  
  public int getValue(){
    return value;
  }

}
