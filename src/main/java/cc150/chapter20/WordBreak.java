package cc150.chapter20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Write a program to find the longest word made of other words
 * @author leili
 *
 */
public class WordBreak {
  
  public String getLongestWord(String[] words){
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    for (int i = 0; i < words.length; i++)
      map.put(words[i], true);
    
    Arrays.sort(words, new LengthComparator());
    for (int i = 0; i < words.length; i++){
      if (canBuild(words[i], map, true))
        return words[i];
    }
    return "";
  }
  
  private boolean canBuild(String s, HashMap<String,Boolean> map, boolean isOrigin){
    if (map.containsKey(s) && !isOrigin)
      return map.get(s);
    
    for (int i = 0; i < s.length(); i++){
      String left = s.substring(0,i);
      String right = s.substring(i);
      if (map.containsKey(left) && map.get(left) == true && canBuild(right, map, false))
        return true;
    }
    
    map.put(s, false);
    return false;
  }
  
  class LengthComparator implements Comparator<String>{

    public int compare(String o1, String o2) {
      if (o1.length() < o2.length())
        return 1;
      else if (o1.length() > o2.length())
        return -1;
      return 0;
    }
    
  }

}
