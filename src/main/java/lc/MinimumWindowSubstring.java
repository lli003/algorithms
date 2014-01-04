package lc;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

  /**
   * naive solution: O(n^3) check each substring
   * 
   * @param S
   * @param T
   * @return
   */
  public String minWindow(String S, String T) {
    assert (S != null && T != null);
    if (S.length() < T.length())
      return "";

    String min = "";
    int len = Integer.MAX_VALUE;
    for (int i = 0; i < S.length(); i++) {
      for (int j = i + T.length(); j <= S.length(); j++) {
        String s = S.substring(i, j);
        if (isSubstring(s, T) && s.length() < len)
          min = s;
      }
    }
    return min;
  }

  private boolean isSubstring(String s, String t) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c))
        map.put(c, map.get(c) + 1);
      else
        map.put(c, 1);
    }
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (!map.containsKey(c))
        return false;
      int count = map.get(c) - 1;
      if (count < 0)
        return false;
      map.put(c, count);
    }
    return true;
  }

  /**
   * two pointers of S to maintain the window
   * 
   * @param S
   * @param T
   * @return
   */
  public String minWindow2(String S, String T) {
    if (S == null || T == null || S.length() == 0 || T.length() == 0
        || S.length() < T.length())
      return "";

    int[] needToFind = new int[256];
    int[] hasFound = new int[256];

    for (int i = 0; i < T.length(); i++) {
      needToFind[T.charAt(i)]++;
    }

    int winBegin = 0, winEnd = 0;
    int minLen = Integer.MAX_VALUE, count = 0;
    for (int begin = 0, end = 0; end < S.length(); end++) {
      if (needToFind[S.charAt(end)] == 0)
        continue;
      hasFound[S.charAt(end)]++;
      if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
        count++;

      if (count == T.length()) {
        while (needToFind[S.charAt(begin)] == 0
            || hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
          if (hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)])
            hasFound[S.charAt(begin)]--;
          begin++;
        }
        int winLen = end - begin + 1;
        if (winLen < minLen) {
          winBegin = begin;
          winEnd = end;
          minLen = winLen;
        }
      }
    }

    if (count == T.length())
      return S.substring(winBegin, winEnd + 1);
    return "";
  }

  public static void main(String[] args) {
    MinimumWindowSubstring m = new MinimumWindowSubstring();
    System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
  }
}
