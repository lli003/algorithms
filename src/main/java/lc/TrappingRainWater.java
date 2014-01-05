package lc;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * @author leili
 *
 */
public class TrappingRainWater {

  /**
   * basic idea: trapped water is only related to the left highest and the right highest points with respect to index i
   * then scan the array twice:
   *    first time: from left to right, store the left highest points
   *    second time: from right to left, find the right highest points, if min(left, right) > A[i], then water can be trapped.
   * @param A
   * @return
   */
  public int trap(int[] A) {
    assert (A != null);
    if (A.length < 2)
      return 0;

    int[] leftMaxes = new int[A.length];
    leftMaxes[0] = 0;
    int maxL = A[0];
    for (int i = 1; i < A.length; i++) {
      leftMaxes[i] = maxL;
      if (maxL < A[i])
        maxL = A[i];
    }

    int maxR = A[A.length - 1];
    int trapped = 0;
    for (int i = A.length - 2; i > 0; i--) {
      int left = leftMaxes[i];
      int right = maxR;
      int contained = Math.min(left, right);
      if (contained > A[i])
        trapped += contained - A[i];
      if (maxR < A[i])
        maxR = A[i];
    }
    return trapped;
  }

}
