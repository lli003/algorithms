package lc;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

A string with length 0 is considered to be a valid palindrome
 * @author leili
 *
 */
public class ValidPalindrome {

  public boolean isPalindrome(String s) {
    if (s.length() == 0)
      return true;

    s = s.toLowerCase();
    int l = 0, r = s.length() - 1;
    while (l < r) {
      char lc = s.charAt(l);
      char rc = s.charAt(r);
      if (!Character.isLetterOrDigit(lc)) {
        l++;
        continue;
      }
      if (!Character.isLetterOrDigit(rc)) {
        r--;
        continue;
      }
      if (lc != rc)
        return false;
      else {
        l++;
        r--;
      }
    }
    return true;

  }

}
