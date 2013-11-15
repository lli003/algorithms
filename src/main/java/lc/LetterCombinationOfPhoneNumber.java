package lc;

import java.util.ArrayList;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author leili
 *
 */
public class LetterCombinationOfPhoneNumber {

  public ArrayList<String> letterCombinations(String digits) {
    ArrayList<String> result = new ArrayList<String>();
    if (digits == null || digits.length() == 0) {
      result.add("");
      return result;
    }

    char[][] map = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
        { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' },
        { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
    StringBuffer sb = new StringBuffer("");
    return dfs(digits, 0, sb, result, map);
  }

  private ArrayList<String> dfs(String digits, int start, StringBuffer sb,
      ArrayList<String> result, char[][] map) {
    if (start >= digits.length()) {
      result.add(sb.toString());
      return result;
    }

    char c = digits.charAt(start);
    int index = c - '1' - 1;
    for (int i = 0; i < map[index].length; i++) {
      sb.append(map[index][i]);
      dfs(digits, start + 1, sb, result, map);
      sb.deleteCharAt(sb.length() - 1);
    }
    return result;
  }

}
