package lc;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * @author lli003
 *
 */
public class SearchInsertPosition {
  
  /**
   * O(n) solution
   * @param A
   * @param target
   * @return
   */
  public int searchInsert(int[] A, int target){
    if (A.length == 0)
      return 0;
    
    for (int i = 0; i < A.length; i++){
      if (target <= A[i])
        return i;
    }
    
    return A.length;
  }
}
