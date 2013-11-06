package lc;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * @author lli003
 *
 */
public class SetMatrixZeros {
  
  /**
   * use extra space of O(m+n)
   * @param matrix
   */
  public void setZeroes(int[][] matrix){
    if (matrix.length == 0)
      return;
    
    boolean[] row = new boolean[matrix.length];
    boolean[] column = new boolean[matrix[0].length];
    
    for (int i = 0; i < row.length; i++){
      for (int j = 0; j < column.length; j++){
        if (matrix[i][j] == 0){
          row[i] = true;
          column[j] = true;
        }
      }
    }
    
    for (int i = 0; i < row.length; i++){
      if (row[i]){
        for (int j = 0; j < column.length; j++){
          matrix[i][j] = 0;
        }
      }
    }
    
    for (int i = 0; i < column.length; i++){
      if (column[i]){
        for (int j = 0; j < row.length; j++){
          matrix[j][i] = 0;
        }
      }
    }
  }

}
