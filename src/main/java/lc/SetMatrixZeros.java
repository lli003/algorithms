package lc;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * @author lli003
 * 
 */
public class SetMatrixZeros {

  /**
   * use extra space of O(m+n)
   * 
   * @param matrix
   */
  public void setZeroes(int[][] matrix) {
    if (matrix.length == 0)
      return;

    boolean[] row = new boolean[matrix.length];
    boolean[] column = new boolean[matrix[0].length];

    for (int i = 0; i < row.length; i++) {
      for (int j = 0; j < column.length; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          column[j] = true;
        }
      }
    }

    for (int i = 0; i < row.length; i++) {
      if (row[i]) {
        for (int j = 0; j < column.length; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < column.length; i++) {
      if (column[i]) {
        for (int j = 0; j < row.length; j++) {
          matrix[j][i] = 0;
        }
      }
    }
  }

  /**
   * use constant space to perform in-place operation
   * 
   * @param matrix
   */
  public void setZeroes2(int[][] matrix) {
    if (matrix.length == 0)
      return;

    // flags to indicate if the first row or column has zeroes
    boolean row0 = false, column0 = false;

    // check if the first row or column has zeroes
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        row0 = true;
        break;
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        column0 = true;
        break;
      }
    }

    // use the first row and first column to store 0 info of rows and columns
    // except 0th row and 0th column
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    // set zeroes of rows and columns except 0th row and 0th column
    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < matrix[i].length; j++)
          matrix[i][j] = 0;
      }
    }
    for (int i = 1; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 1; j < matrix.length; j++)
          matrix[j][i] = 0;
      }
    }

    // if the 0th row or 0th column has zeroes, set them as zeroes
    if (row0) {
      for (int i = 0; i < matrix[0].length; i++)
        matrix[0][i] = 0;
    }

    if (column0) {
      for (int i = 0; i < matrix.length; i++)
        matrix[i][0] = 0;
    }

    return;
  }

}
