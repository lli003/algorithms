package basic.string;

import java.util.HashSet;
import java.util.Set;

/**
 * given a string, find all the substrings that are palindrome
 * @author leili
 *
 */
public class PalindromesInString {
  
  /**
   * expand from an index to the left and right
   * O(n^2) time
   * @param s
   * @return
   */
  public Set<String> findPalindromesInString(String s){
    assert(s != null);
    Set<String> result = new HashSet<String>();
    if (s.length() == 0)
      return result;
    
    for (int i = 0; i < s.length(); i++){
      expand(s, i, i + 1, result);
      expand(s, i, i, result);
    }
    
    return result;
  }
  
  private void expand(String s, int i, int j, Set<String> result){
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
      result.add(s.substring(i,j+1));
      i--;
      j++;
    }
  }
  
  public static void main(String[] args){
    PalindromesInString pis = new PalindromesInString();
    Set<String> result = pis.findPalindromesInString("acbbcadd");
    for (String s : result)
      System.out.println(s);
  }

}
