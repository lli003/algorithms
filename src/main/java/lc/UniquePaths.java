package lc;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * @author leili
 *
 */
public class UniquePaths {
  
  /**
   * two-dimensional dp
   * the solution to each point depends on the solution to its left point and up point.
   * @param m
   * @param n
   * @return
   */
  public int uniquePaths(int m, int n){
    int[][] paths = new int[m][m];
    paths[0][0] = 1;
    
    for (int i = 0; i < m; i++){
      for (int j = 0; j < n; j++){
        if (i != 0)
          paths[i][j] += paths[i-1][j];
        
        if (j != 0)
          paths[i][j] += paths[i][j-1];
      }
    }
    
    return paths[paths.length - 1][paths[0].length - 1];
  }
  
}
