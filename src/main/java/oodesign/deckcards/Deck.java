package oodesign.deckcards;

import java.util.ArrayList;

public class Deck <T extends Card> {

  private ArrayList<T> cards; // all cards
  private int dealtIndex = 0; // make default index
  
  public void setDeckofCards(ArrayList<T> deckOfCards) {
    cards = deckOfCards;
  }
  
  public void shuffle(){
    
  }
  
  public int remainingCards (){
    return cards.size() - dealtIndex;
  }
  
  public T dealCard(){
    /* remove card at index dealtindex*/
    T t = cards.get(dealtIndex);
    cards.remove(dealtIndex);
    return t;
  }
  
  public ArrayList<T> dealCards(int num){
    int count = 0;
    ArrayList<T> hands = new ArrayList<T>();
    while (count < num){
      T t = cards.get(dealtIndex);
      cards.remove(dealtIndex);
      hands.add(t);
      count++;
    }
    return hands;
  }
}
