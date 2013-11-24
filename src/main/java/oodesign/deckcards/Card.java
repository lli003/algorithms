package oodesign.deckcards;

/**
 * abstract class for creating deck of cards
 * @author leili
 *
 */
public abstract class Card {
  
  private boolean available = true;
  
  /* number of cards 1 - 13 */
  protected int faceValue;
  protected Suit suit;
  
  public Card(int c, Suit s){
    faceValue = c;
    suit = s;
  }
  
  public abstract int value();
  
  public Suit suit(){
    return suit;
  }
  
  public boolean isAvailable(){
    return available;
  }
  
  public void markAvailable(){
    available = true;
  }
  
  public void markUnAvailable(){
    available = false;
  }

}
