package lc;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * @author leili
 *
 */
public class MaximumSubArray {
  
  /**
   * one-dimensional dp
   * track the maximum value
   * @param A
   * @return
   */
  public int maxSubArray(int[] A){
    int result = A[0], sum = 0;
    for (int i = 0; i < A.length; i++){
      sum = Math.max(sum + A[i], A[i]);
      result = Math.max(result, sum);
    }
    return result;
  }

}
