package lc;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * @author leili
 *
 */
public class LongestPalindrome {

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

}
