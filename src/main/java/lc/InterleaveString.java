package lc;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 * @author leili
 * 
 */
public class InterleaveString {

  /**
   * recursive solution: time limit exceeded
   * 
   * @param s1
   * @param s2
   * @param s3
   * @return
   */
  public boolean isInterleave(String s1, String s2, String s3) {
    assert (s1 != null && s2 != null && s3 != null);
    if (s1.length() + s2.length() != s3.length())
      return false;
    return isInterleave(s1, 0, s2, 0, s3, 0);
  }

  private boolean isInterleave(String s1, int l1, String s2, int l2, String s3,
      int l3) {
    if (l1 == s1.length() && l2 == s2.length() && l3 == s3.length())
      return true;

    boolean match = false;
    if (l1 < s1.length() && s1.charAt(l1) == s3.charAt(l3)) {
      match = isInterleave(s1, l1 + 1, s2, l2, s3, l3 + 1);
    }
    if (!match && l2 < s2.length() && s2.charAt(l2) == s3.charAt(l3)) {
      match = isInterleave(s1, l1, s2, l2 + 1, s3, l3 + 1);
    }
    return match;
  }

  /**
   * two dimensional dp
   * @param s1
   * @param s2
   * @param s3
   * @return
   */
  public boolean isInterleave2(String s1, String s2, String s3) {
    assert (s1 != null && s2 != null && s3 != null);
    if (s1.length() + s2.length() != s3.length())
      return false;

    /* two dimensional dp. */
    boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];

    /* initialization. */
    match[0][0] = true;
    for (int i = 1; i <= s1.length(); i++) {
      if (s1.charAt(i - 1) == s3.charAt(i - 1))
        match[i][0] = true;
      else
        break;
    }
    for (int i = 1; i <= s2.length(); i++) {
      if (s2.charAt(i - 1) == s3.charAt(i - 1))
        match[0][i] = true;
      else
        break;
    }

    /*
     * fill in the rest entries based on the idea: isInterleave (s1, l1, s2, l2,
     * s3, l3) = ((s1.lastchar == s3.lastchar) && isInterleave(s1, l1-1, s2, l2,
     * s3, l3-1)) || ((s2.lastchar == s3.lastchar) && isInterleave(s1, l1, s2,
     * l2-1, s3, l3-1))
     */
    for (int i = 1; i <= s1.length(); i++) {
      char c1 = s1.charAt(i - 1);
      for (int j = 1; j <= s2.length(); j++) {
        char c2 = s2.charAt(j - 1);
        int l3 = i + j;
        char c3 = s3.charAt(l3 - 1);
        if (c1 == c3)
          match[i][j] = match[i - 1][j] || match[i][j];
        if (c2 == c3)
          match[i][j] = match[i][j - 1] || match[i][j];
      }
    }
    return match[s1.length()][s2.length()];
  }

  public static void main(String[] args) {
    InterleaveString is = new InterleaveString();
    String s1 = "aabcc", s2 = "dbbca";
    System.out.println(is.isInterleave(s1, s2, "aadbbcbcac"));
    System.out.println(is.isInterleave(s1, s2, "aadbbbaccc"));
  }

}
