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
  
  /**
   * O(lgn) solution
   * @param A
   * @param target
   * @return
   */
  public int searchInsert2(int[] A, int target){
    assert(A != null);
    
    if (A.length == 0)
      return 0;
    
    if (A[0] >= target)
      return 0;
    if (A[A.length - 1] < target)
      return A.length;
    
    int l = 0, r = A.length - 1;
    while (l < r){
      int m = l + (r-l)/2;
      if (A[m] == target)
        return m;
      else if (A[m] < target)
        l = m + 1;
      else
        r = m - 1;
    }
    
    if (A[l] >= target)
      return l;
    else
      return l+1;
  }
}
