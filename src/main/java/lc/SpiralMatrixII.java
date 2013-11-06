package lc;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * @author lli003
 *
 */
public class SpiralMatrixII {

  /**
   * generate matrix based on spiral order
   * @param n
   * @return
   */
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int start = 0, end = n - 1;
    int num = 1;

    // spiral check
    // start from going right, then down, then left, then up
    while (start < end) {
      for (int i = start; i < end; i++)
        matrix[start][i] = num++;
      for (int i = start; i < end; i++)
        matrix[i][end] = num++;
      for (int i = end; i > start; i--)
        matrix[end][i] = num++;
      for (int i = end; i > start; i--)
        matrix[i][start] = num++;

      // go into the inner loop
      start++;
      end--;
    }

    // when n is odd
    if (start == end) {
      matrix[start][end] = num;
    }

    return matrix;
  }

}
