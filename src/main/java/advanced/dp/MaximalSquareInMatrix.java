package advanced.dp;

/**
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

For example, consider the below binary matrix.

 
   0  1  1  0  1 
   1  1  0  1  0 
   0  1  1  1  0
   1  1  1  1  0
   1  1  1  1  1
   0  0  0  0  0
The maximum square sub-matrix with all set bits is

    1  1  1
    1  1  1
    1  1  1
 * @author leili
 *
 */
public class MaximalSquareInMatrix {
  
  public void maxSubSquare(char[][] matrix){
    assert(matrix != null);
    if (matrix.length == 0)
      return;
    
    /* initialization. */
    int[][] mat = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++){
      if (matrix[i][0] == '1')
        mat[i][0] = 1;
      else if (matrix[i][0] == '0')
        mat[i][0] = 0;
    }
    for (int j = 0; j < matrix[0].length; j++){
      if (matrix[0][j] == '1')
        mat[0][j] = 1;
      else if (matrix[0][j] == '0')
        mat[0][j] = 0;
    }
    
    /* fill in the left entries. */
    for (int i = 1; i < matrix.length; i++){
      for (int j = 1; j < matrix[0].length; j++){
        if (matrix[i][j] == '1'){
          mat[i][j] = Math.min(mat[i-1][j-1], Math.min(mat[i-1][j], mat[i][j-1])) + 1;
        } else if (matrix[i][j] == '0'){
          mat[i][j] = 0;
        }
      }
    }
    
    /* find the max entry. */
    int maxE = mat[0][0], maxI = 0, maxJ = 0;
    for (int i = 0; i < mat.length; i++){
      for (int j = 0; j < mat[0].length; j++){
        if (maxE < mat[i][j]){
          maxE = mat[i][j];
          maxI = i;
          maxJ = j;
        }
      }
    }
    
    for (int i = maxI; i > maxI - maxE; i--){
      for (int j = maxJ; j > maxJ - maxE; j--){
        System.out.printf("%s ", matrix[i][j]);
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args){
    MaximalSquareInMatrix s = new MaximalSquareInMatrix();
    char[][] matrix = {{'0', '1', '1', '0', '1'}, 
                       {'1', '1', '0', '1', '0'}, 
                       {'0', '1', '1', '1', '0'},
                       {'1', '1', '1', '1', '0'},
                       {'1', '1', '1', '1', '1'},
                       {'0', '0', '0', '0', '0'}};
    s.maxSubSquare(matrix);
  }

}
