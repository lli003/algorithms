package lc;

/**
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 * @author lli003
 *
 */
public class RegularExpressionMatching {

  public boolean isMatch(String s, String p) {
    if (s == null)
      return p == null;
    return match(s, p, 0, 0);
  }

  /* recursive solution to check match. */
  private boolean match(String s, String p, int i, int j) {
    if (j == p.length())
      return i == s.length();

    /* if the next character of p is not '*'. */
    if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
      /* if s reaches the end, then no match. */
      if (i == s.length())
        return false;

      /* check if the next character of both s and p matches. */
      return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
          && match(s, p, ++i, ++j);
    }

    /* if the next character of p is '*', then skip two characters of p to check if s matches p */
    while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
      if (match(s, p, i, j + 2))
        return true;
      i++;
    }

    return match(s, p, i, j + 2);

  }
}
