package lc;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 * @author leili
 *
 */
public class PalindromePartition {

  /**
   * use depth-first search to partition
   * @param s
   * @return
   */
  public ArrayList<ArrayList<String>> partition(String s) {
    if (s == null)
      return new ArrayList<ArrayList<String>>();

    return dfs(s);
  }

  private ArrayList<ArrayList<String>> dfs(String s) {
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    if (s.length() == 0) {
      result.add(new ArrayList<String>());
      return result;
    }

    if (s.length() == 1) {
      result.add(new ArrayList<String>());
      result.get(0).add(s);
      return result;
    }

    for (int i = 1; i <= s.length(); i++) {
      if (isPalindrome(s.substring(0, i))) {
        ArrayList<ArrayList<String>> tmp = dfs(s.substring(i));
        for (ArrayList<String> list : tmp) {
          list.add(0, s.substring(0, i));
          result.add(list);
        }
      }
    }
    return result;
  }

  private boolean isPalindrome(String s) {
    if (s == null)
      return false;
    if (s.length() == 1)
      return true;
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }

}
