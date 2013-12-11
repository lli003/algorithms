package lc;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author leili
 * 
 */
public class LongestPalindrome {

  /**
   * O(n^3) time
   * 
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    int maxL = 0;
    String palin = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (j - i >= maxL && isPalindrome(s.substring(i, j + 1))) {
          maxL = j - i;
          palin = s.substring(i, j + 1);
        }
      }
    }
    return palin;
  }

  private boolean isPalindrome(String s) {
    if (s.length() == 0)
      return false;
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }

  /**
   * O(n^2) time
   * start from i, or i, i+1, expand the string to left and to right
   * @param s
   * @return
   */
  public String longestPalindrome2(String s) {
    assert (s != null);

    if (s.length() == 0)
      return "";

    String longest = s.substring(0, 1);
    for (int i = 0; i < s.length(); i++) {
      String p1 = expandFromCenter(s, i, i);
      if (p1.length() > longest.length())
        longest = p1;

      p1 = expandFromCenter(s, i, i + 1);
      if (p1.length() > longest.length())
        longest = p1;
    }

    return longest;
  }

  private String expandFromCenter(String s, int i, int j) {
    while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
      i--;
      j++;
    }
    return s.substring(i + 1, j);
  }

}
