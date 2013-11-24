package oodesign.deckcards;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard>{
  
  public int score(){
    ArrayList<Integer> scores = possibleScores();
    return Integer.MAX_VALUE;
  }
  
  private ArrayList<Integer> possibleScores() {
    return new ArrayList<Integer>();
  }
  
  public boolean busted(){
    return score() > 21;
  }
  
  public boolean is21(){
    return score() == 21;
  }

}
