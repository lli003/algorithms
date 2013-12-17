package basic.string;

import java.util.Arrays;

public class LongestRepeatedSubstring {
  
  /**
   * find the longest common prefix of two strings
   * @param a
   * @param b
   * @return
   */
  public static String longestCommonPrefix(String a, String b){
    int l = Math.min(a.length(), b.length());
    for (int i = 0; i < l; i++){
      if (a.charAt(i) != b.charAt(i))
        return a.substring(0,i);
    }
    return a.substring(0,l);
  }
  
  /**
   * find the longest repeated substring using suffix
   * @param s
   * @return
   */
  public static String longestRepeatedSubstring(String s){
    int N = s.length();
    String[] suffixes = new String[N];
    
    for (int i = 0; i < N; i++)
      suffixes[i] = s.substring(i, N);
    
    /* bring subffixes with common prefix together. */
    Arrays.sort(suffixes);
    
    /* compare the adjacent suffixes. */
    String longest = "";
    for (int i = 0; i < suffixes.length - 1; i++){
      String common = longestCommonPrefix(suffixes[i], suffixes[i+1]);
      if (common.length() > longest.length())
        longest = common;
    }
    
    return longest;
  }

}
