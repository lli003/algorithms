package lc;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 * @author lli003
 *
 */
public class Search2DMatrix {
  
  /**
   * binary search on the first elements of each row, and then on the matched row
   * Time Complexity O(lgm + lgn)
   * @param matrix
   * @param target
   * @return
   */
  public boolean searchMatrix(int[][] matrix, int target){
    
    if (matrix.length == 0)
      return false;
    
    int start = 0, end = matrix.length - 1;
    while (start < end){
      int mid = start + (end - start)/2;
      if (target == matrix[mid][0])
        return true;
      else if (target < matrix[mid][0])
        end = mid - 1;
      else if (target < matrix[mid+1][0]){
        start = mid;
        break;
      } else
        start = mid + 1;
    }
    
    int row = start;
    start = 0;
    end = matrix[row].length - 1;
    while (start <= end){
      int mid = start + (end - start)/2;
      if (target == matrix[row][mid])
        return true;
      else if (target < matrix[row][mid])
        end = mid - 1;
      else
        start = mid + 1;
    }
    return false;
  }
  
  public boolean searchMatrix2(int[][] matrix, int target){
    int row = 0, col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0){
        if (matrix[row][col] == target)
            return true;
        else if (matrix[row][col] < target)
            row++;
        else
            col--;
    }
    return false;
  }
  
}
