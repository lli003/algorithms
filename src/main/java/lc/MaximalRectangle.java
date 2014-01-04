package lc;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * @author leili
 *
 */
public class MaximalRectangle {

  /**
   * basic idea: accumulate the 1's in the matrix for each row from top to bottom
   * then each row defines the histogram of valid height of rectangles
   * @param matrix
   * @return
   */
  public int maximalRectangle(char[][] matrix) {
    assert (matrix != null);
    if (matrix.length == 0)
      return 0;

    int[][] hist = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1')
          hist[i][j] = 1;
        if (i >= 1 && hist[i][j] == 1)
          hist[i][j] = hist[i - 1][j] + 1;
      }
    }
    int max = 0;
    for (int i = 0; i < hist.length; i++) {
      max = Math.max(max, largestRectangleArea(hist[i]));
    }
    return max;
  }

  /**
   * find the maximal rectangle area from a given height array
   * @param height
   * @return
   */
  private int largestRectangleArea(int[] height) {
    Stack<Integer> stack = new Stack<Integer>();
    int i = 0, max = 0;
    height = Arrays.copyOf(height, height.length + 1);
    while (i < height.length) {
      if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
        stack.push(i++);
      } else {
        int t = stack.pop();
        max = Math.max(max, height[t]
            * (stack.isEmpty() ? i : i - stack.peek() - 1));
      }
    }
    return max;
  }

}
