package lc;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5
 * ] ]
 * 
 * @author lli003
 * 
 */
public class SpiralMatrixII {

  /**
   * generate matrix based on spiral order
   * 
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

  public int[][] generateMatrix2(int n) {
    if (n == 0)
      return new int[0][0];

    int[][] matrix = new int[n][n];
    int num = 0;
    int left = -1, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
    while (left <= right && top <= bottom) {
      for (int j = ++left; top <= bottom && j <= right; j++)
        matrix[top][j] = ++num;
      for (int i = ++top; left <= right && i <= bottom; i++)
        matrix[i][right] = ++num;
      for (int j = --right; top <= bottom && j >= left; j--)
        matrix[bottom][j] = ++num;
      for (int i = --bottom; left <= right && i >= top; i--)
        matrix[i][left] = ++num;
    }

    return matrix;
  }

}
