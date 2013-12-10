package lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author leili
 * 
 */
public class WordBreakII {

  /**
   * dfs solution
   * large data TLE
   * @param s
   * @param dict
   * @return
   */
  public ArrayList<String> wordBreak(String s, Set<String> dict) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    assert (s != null && dict != null);
    ArrayList<String> result = new ArrayList<String>();
    if (s.length() == 0 || dict.size() == 0)
      return result;
    StringBuffer sb = new StringBuffer("");
    dfs(s, dict, 0, 0, sb, result);
    return result;
  }

  private void dfs(String s, Set<String> dict, int start, int depth,
      StringBuffer sb, ArrayList<String> result) {
    if (start == s.length()) {
      result.add(sb.toString());
      return;
    }

    for (String a : dict) {
      int len = a.length();
      int end = start + len;
      if (end > s.length())
        continue;
      String sub = s.substring(start, end);
      if (sub.equals(a)) {
        if (depth != 0)
          sb.append(" ");
        sb.append(sub);
        dfs(s, dict, end, depth + 1, sb, result);
        sb.delete(sb.length() - sub.length(), sb.length());
        if (depth != 0)
          sb.deleteCharAt(sb.length() - 1);
      }
    }
  }

  public static void main(String[] args) {
    WordBreakII wb = new WordBreakII();
    Set<String> dict = new HashSet<String>();
    dict.add("cat");
    dict.add("cats");
    dict.add("and");
    dict.add("sand");
    dict.add("dog");
    String s = "catsanddog";
    ArrayList<String> result = wb.wordBreak(s, dict);
    for (String a : result)
      System.out.println(a);
  }

}
