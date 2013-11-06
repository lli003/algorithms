package lc;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * @author lli003
 *
 */
public class RotateImage {
  
  /**
   * first reverse the matrix along the negative diagonal
   * then reverse the matrix along the vertical mid row
   * @param matrix
   */
  public void rotate(int[][] matrix){
    int n = matrix.length;
    
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n-1-i; j++){
        swap(matrix, i, j, n-1-j, n-1-i);
      }
    }
    
    for (int i = 0; i < n/2; i++){
      for (int j = 0; j < n; j++){
        swap(matrix, i, j, n-1-i, j);
      }
    }
  }
  
  private void swap(int[][] matrix, int i1, int j1, int i2, int j2){
    int temp = matrix[i1][j1];
    matrix[i1][j1] = matrix[i2][j2];
    matrix[i2][j2] = temp;
  }

}
