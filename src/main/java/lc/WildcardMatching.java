package lc;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 * @author leili
 *
 */
public class WildcardMatching {

  /**
   * recursive solution, cannot pass large test case
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch(String s, String p) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    assert (s != null && p != null);
    return match(s, p, 0, 0);
  }

  private boolean match(String s, String p, int ls, int lp) {
    if (ls == s.length() || lp == p.length())
      return ls == s.length() && lp == p.length();
    else if (p.charAt(lp) == '*') {
      while (lp < p.length() && p.charAt(lp) == '*')
        lp++;
      if (lp == p.length())
        return true;
      while (ls < s.length() && !match(s, p, ls, lp))
        ls++;
      return ls < s.length();
    } else if (s.charAt(ls) == p.charAt(lp) || p.charAt(lp) == '?')
      return match(s, p, ++ls, ++lp);
    else
      return false;
  }
  
  public static void main(String[] args){
    WildcardMatching wm = new WildcardMatching();
    System.out.printf("%s,%s\n", wm.isMatch("aa","a"), false);
    System.out.printf("%s,%s\n", wm.isMatch("aa","aa"), true);
    System.out.printf("%s,%s\n", wm.isMatch("aaa","aa"), false);
    System.out.printf("%s,%s\n", wm.isMatch("aa", "*"), true);
    System.out.printf("%s,%s\n", wm.isMatch("aa", "a*"), true);
    System.out.printf("%s,%s\n", wm.isMatch("ab", "?*"), true);
    System.out.printf("%s,%s\n", wm.isMatch("aab", "c*a*b"), false);
    System.out.printf("%s,%s\n", wm.isMatch("abcdef", "a?c*f"), true);
  }

}
