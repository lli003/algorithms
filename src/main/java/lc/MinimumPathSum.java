package lc;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * @author leili
 *
 */
public class MinimumPathSum {
  
  /**
   * one-dimensional dp
   * @param grid
   * @return
   */
  public int minPathSum(int[][] grid){
    int m = grid.length, n = grid[0].length;
    int[] min = new int[n];
    
    for (int i = 0; i < m; i++){
      for (int j = 0; j < n; j++){
        if (j == 0)
          min[j] += grid[i][j];
        else if (i == 0)
          min[j] = grid[i][j] + min[j-1];
        else
          min[j] = grid[i][j] + Math.min(min[j], min[j-1]);
      }
    }
    return min[n-1];
  }

}
