package lc;

import java.util.ArrayList;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author lli003
 * 
 */
public class SearchForARange {

  public int[] searchRange(int[] A, int target) {
    assert (A != null);

    int[] result = new int[2];
    ArrayList<Integer> list = new ArrayList<Integer>();

    /* a recursive solution for binary search in an array. */
    search(A, target, 0, A.length - 1, list);

    if (list.size() == 0) {
      result[0] = -1;
      result[1] = -1;
    } else {
      result[0] = list.get(0);
      result[1] = list.get(1);
    }
    return result;
  }
  
  /**
   * recursive search
   * @param A
   * @param target
   * @param l
   * @param r
   * @param list
   */
  private void search(int[] A, int target, int l, int r, ArrayList<Integer> list) {
    if (l > r)
      return;

    int m = l + (r - l) / 2;
    
    if (A[m] < target)
      search(A, target, m + 1, r, list);
    else if (A[m] > target)
      search(A, target, l, m - 1, list);
    else {
      if (list.size() == 0) {
        list.add(m);
        list.add(m);
      } else {
        if (m > list.get(1))
          list.set(1, m);
        if (m < list.get(0))
          list.set(0, m);
      }
      search(A, target, l, m - 1, list);
      search(A, target, m + 1, r, list);
    }
  }

}
