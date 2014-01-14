package lc;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 * @author leili
 *
 */
public class WordBreak {

  /**
   * one-dimensional dp
   * a solution to a string depends on the solutions to the substrings of this string
   * @param s
   * @param dict
   * @return
   */
  public boolean wordBreak(String s, Set<String> dict){
    if (s == null || dict == null)
      return false;
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++)
      for (int k = 0; k < i; k++)
        if (dp[k] && dict.contains(s.substring(k,i)))
          dp[i] = true;
    
    return dp[s.length()];
  }
  
  public boolean wordBreak2(String s, Set<String> dict){
    if (dict.contains(s))
      return true;
    int len = s.length();
    for(int i = 1; i < len; i++){
      String prefix = s.substring(0, i);
      if (dict.contains(prefix)){
        String suffix = s.substring(i);
        if (wordBreak2(suffix, dict)){
          return true;
        }
      }
    }
    return false;
  }
  
  public static void main(String[] args){
    WordBreak wb = new WordBreak();
    String s = "test";
    Set<String> dict = new HashSet<String>();
    dict.add("tes");
    dict.add("t");
    dict.add("s");
    dict.add("te");
    dict.add("e");
    
    System.out.println(wb.wordBreak(s, dict));
    System.out.println(wb.wordBreak2(s, dict));
  }

}
