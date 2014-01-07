package lc;

import java.util.ArrayList;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 * @author lli003
 *
 */
public class SpiralMatrix {
  
  public ArrayList<Integer> spiralOrder(int[][] matrix){
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0)
        return result;
    
    int left = -1, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
    while (left <= right && top <= bottom){
        for (int j = ++left; top <= bottom && j <= right; j++)
            result.add(matrix[top][j]);
        for (int i = ++top; left <= right && i <= bottom; i++)
            result.add(matrix[i][right]);
        for (int j = --right; top <= bottom && j >= left; j--)
            result.add(matrix[bottom][j]);
        for (int i = --bottom; left <= right && i >= top; i--)
            result.add(matrix[i][left]);
    }
    return result;
  }

}
