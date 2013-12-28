package cc150.chapter01;

import java.util.ArrayList;

/**
 * remove duplicate characters in a string 
 * @author leili
 *
 */
public class Question3 {

  /**
   * basic idea: use additional space to store characters seen so far
   * @param s
   * @return
   */
  public String removeDuplicates(String s){
    assert(s != null);
    if (s.length() < 2)
      return s;
    
    ArrayList<Character> list = new ArrayList<Character>();
    for (int i = 0; i < s.length(); i++){
      if (!list.contains(s.charAt(i)))
        list.add(s.charAt(i));
    }
    
    StringBuffer sb = new StringBuffer();
    for (Character c : list)
      sb.append(c);
    return sb.toString();
  }
  
}
