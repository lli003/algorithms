package lc;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 * @author leili
 *
 */
public class LengthOfLastWord {

  public int lengthOfLastWord(String s) {
    char[] as = s.toCharArray();
    if (as.length == 0)
      return 0;
    int n = as.length - 1;
    while (n >= 0 && as[n] == ' ')
      n--;

    int count = 0;
    if (n >= 0) {
      while (n >= 0 && as[n] != ' ') {
        count++;
        n--;
      }
    }
    return count;
  }

}
