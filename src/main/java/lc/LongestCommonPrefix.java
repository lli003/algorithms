package lc;

import java.util.Arrays;

public class LongestCommonPrefix {

  /**
   * Write a function to find the longest common prefix string amongst an array
   * of strings.
   * 
   * @param strs
   * @return
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0)
      return "";

    if (strs.length == 1)
      return strs[0];

    String start = strs[0];
    for (int i = 1; i < strs.length; i++) {
      start = commonPrefix(start, strs[i]);
    }
    return start;
  }

  private String commonPrefix(String a, String b) {
    int l = Math.min(a.length(), b.length());
    StringBuffer sb = new StringBuffer("");
    for (int i = 0; i < l; i++) {
      if (a.charAt(i) == b.charAt(i))
        sb.append(a.charAt(i));
      else
        break;
    }
    return sb.toString();
  }

  /**
   * sort the array first to ensure the increasing length
   * @param strs
   * @return
   */
  public String longestCommonPrefix2(String[] strs) {
    if (strs.length == 0)
      return "";

    Arrays.sort(strs);

    for (int i = 0; i < strs[0].length(); i++) {
      for (int j = 1; j < strs.length; j++) {
        if (strs[j].charAt(i) != strs[j - 1].charAt(i))
          return strs[0].substring(0, i);
      }
    }
    return strs[0];
  }
  
  public static void main(String[] args){
    String[] strs = {"aaac", "aaa", "aa"};
    Arrays.sort(strs);
    for (String s : strs)
      System.out.println(s);
    
    LongestCommonPrefix lcp = new LongestCommonPrefix();
    System.out.println(lcp.longestCommonPrefix2(strs));
  }

}
