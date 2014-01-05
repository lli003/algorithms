package lc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 * @author leili
 *
 */
public class NQueens {

  public ArrayList<String[]> solveNQueens(int n) {
    ArrayList<String[]> result = new ArrayList<String[]>();
    int[] map = new int[n];
    helper(map, n, 0, result);
    return result;
  }

  private void helper(int[] map, int n, int row, ArrayList<String[]> result) {
    if (row == n) {
      String[] sol = new String[n];
      for (int i = 0; i < n; i++) {
        char[] cc = new char[n];
        Arrays.fill(cc, '.');
        cc[map[i]] = 'Q';
        sol[i] = new String(cc);
      }
      result.add(sol);
    } else {
      for (int i = 0; i < n; i++) {
        boolean valid = true;
        for (int j = 0; j < row; j++) {
          if (i == map[j] || Math.abs(i - map[j]) == row - j) {
            valid = false;
            break;
          }
        }
        if (valid) {
          map[row] = i;
          helper(map, n, row + 1, result);
        }
      }
    }
  }

}
