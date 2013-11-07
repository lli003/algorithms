package lc;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 * @author leili
 *
 */
public class SearchInRoatedArray {

  public int searchRoatedArray(int[] A, int target) {
    int left = 0, right = A.length - 1;

    // binary search
    // be careful about the shrink
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (A[mid] == target)
        return mid;

      // if the mid element is greater than the left one
      // then we need to check if the target is within the range of left to mid
      if (A[left] <= A[mid]) {
        if (A[left] <= target && target < A[mid])
          right = mid - 1;
        else
          left = mid + 1;
      }
      // otherwise, we need to check if the target is within the range of mid to
      // right
      else {
        if (A[mid] < target && target <= A[right])
          left = mid + 1;
        else
          right = mid - 1;
      }
    }
    return -1;
  }

}
