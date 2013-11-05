package lc;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum. For example, given the array
 * [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest
 * sum = 6.
 * 
 * @author leili
 * 
 */
public class MaximumSubArray {

  /**
   * one-dimensional dp track the maximum value
   * 
   * @param A
   * @return
   */
  public int maxSubArray1(int[] A) {
    int result = A[0], sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum = Math.max(sum + A[i], A[i]);
      result = Math.max(result, sum);
    }
    return result;
  }

  /**
   * divide and conqure
   * 
   * @param A
   * @return
   */
  public int maxSubArray2(int[] A) {
    return maxSub(A, 0, A.length - 1);
  }

  /**
   * recursive solution maximum subarray may lie in left, in right, or cross the
   * mid
   * 
   * @param A
   * @param left
   * @param right
   * @return
   */
  private int maxSub(int[] A, int left, int right) {
    if (left > right)
      return 0;
    if (left == right)
      return A[left];
    int mid = (left + right) / 2;
    int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;

    int curMax = 0;
    for (int i = mid - 1; i >= left; i--) {
      curMax += A[i];
      leftMax = Math.max(curMax, leftMax);
    }

    curMax = 0;
    for (int i = mid + 1; i <= right; i++) {
      curMax += A[i];
      rightMax = Math.max(curMax, rightMax);
    }

    // solution cross the mid
    int midMax = Math.max(leftMax, 0) + Math.max(rightMax, 0) + A[mid];

    return Math.max(
        Math.max(maxSub(A, left, mid - 1), maxSub(A, mid + 1, right)), midMax);
  }

}
