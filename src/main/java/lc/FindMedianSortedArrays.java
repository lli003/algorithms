package lc;

/**
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * @author leili
 *
 */
public class FindMedianSortedArrays {

  public double findMedianSortedArrays(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    int total = m + n;

    if (total % 2 == 0)
      return (findMedian(A, 0, m - 1, B, 0, n - 1, total / 2) + findMedian(A,
          0, m - 1, B, 0, n - 1, total / 2 + 1)) / 2;
    else
      return findMedian(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);
  }

  private double findMedian(int[] A, int leftA, int rightA, int[] B, int leftB,
      int rightB, int k) {
    if (leftA > rightA)
      return B[leftB + k - 1];
    if (leftB > rightB)
      return A[leftA + k - 1];

    int midA = (leftA + rightA) / 2;
    int midB = (leftB + rightB) / 2;
    int half = midA - leftA + midB - leftB + 2;
    if (A[midA] >= B[midB]) {
      if (k < half) // remove right half of A
        return findMedian(A, leftA, midA - 1, B, leftB, rightB, k);
      else
        // remove left half of B
        return findMedian(A, leftA, rightA, B, midB + 1, rightB, k
            - (midB + 1 - leftB));
    } else {
      if (k < half) // remove right half of B
        return findMedian(A, leftA, rightA, B, leftB, midB - 1, k);
      else
        // remove left half of A
        return findMedian(A, midA + 1, rightA, B, leftB, rightB, k
            - (midA + 1 - leftA));
    }
  }

}
