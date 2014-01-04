package lc;

/**
 * return the total number of distinct solutions to N-Queens problem
 * @author leili
 *
 */
public class NQueensII {

  public int totalNQueens(int n) {
    /* use an array to store the row numbers with queens. */
    int[] map = new int[n];
    return helper(map, n, 0);
  }

  private int helper(int[] map, int n, int row) {
    if (row >= n || n == 1)
      return 1;

    int sum = 0;
    for (int i = 0; i < n; i++) {
      boolean valid = true;
      for (int j = 0; j < row; j++) {
        /*
         * check if there is conflict within rows, positive and negative
         * diagonals.
         */
        if (i == map[j] || Math.abs(i - map[j]) == row - j) {
          valid = false;
          break;
        }
      }
      if (valid) {
        map[row] = i;
        sum += helper(map, n, row + 1);
      }
    }
    return sum;
  }

}
