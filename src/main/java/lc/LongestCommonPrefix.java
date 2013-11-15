package lc;

public class LongestCommonPrefix {

  /**
   * Write a function to find the longest common prefix string amongst an array of strings.
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

}
