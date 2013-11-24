package oodesign.deckcards;

import java.util.ArrayList;

public class Hand<T extends Card> {
  
  private ArrayList<T> hands = new ArrayList<T>();
  
  public void addCard(T t){
    hands.add(t);
  }
  
  public int score(){
    int value = 0;
    for (T t : hands){
      value += t.value();
    }
    return value;
  }

}
