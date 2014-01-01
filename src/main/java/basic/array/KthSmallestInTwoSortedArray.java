package basic.array;

/**
 * Given two sorted arrays A, B of size m and n respectively. Find the k-th smallest element in the union of A and B. 
 * You can assume that there are no duplicate elements.
 * @author leili
 *
 */
public class KthSmallestInTwoSortedArray {
  
  /**
   * merge two sorted array into a single array, and then get the kth smallest element
   * Time: O(m+n)
   * Space: O(m+n)
   * @param A
   * @param B
   * @param k
   * @return
   */
  public static int kth(int[] A, int[] B, int k){
    int m = A.length;
    int n = B.length;
    
    assert(m >= 0 || n >= 0);
    assert(k > 0 && m+n >= k);
    
    int l = m + n;
    int[] T = new int[l];
    
    /* merge two sorted arrays. */
    while (m > 0 || n > 0){
      int a = m > 0 ? A[m-1] : Integer.MIN_VALUE;
      int b = n > 0 ? B[n-1] : Integer.MIN_VALUE;
      if (a > b){
        T[l-1] = a;
        l--;
        m--;
      } else if (a < b){
        T[l-1] = b;
        l--;
        n--;
      } else {
        T[l-1] = a;
        T[l-2] = b;
        l -= 2;
        m--;
        n--;
      }
    }
    return T[k-1];
  }
  
  /**
   * maintain two pointers for A and B, respectively, and compare with each other until k is reached.
   * Time: O(k)
   * Space: O(1)
   * @param A
   * @param B
   * @param k
   * @return
   */
  public static int kth2(int[] A, int[] B, int k){
    int m = A.length;
    int n = B.length;
    assert(m >= 0 || n >= 0);
    assert(k > 0 && k <= m + n);
    
    int count = 0, la = 0, lb = 0;
    while (true){
      int a = m > 0 && la < m ? A[la] : Integer.MAX_VALUE;
      int b = n > 0 && lb < n ? B[lb] : Integer.MAX_VALUE;
      if (a < b){
        count++;
        if (count == k)
          return a;
        la++;
      } else if (a > b){
        count++;
        lb++;
        if (count == k)
          return b;
      } else {
        count += 2;
        if (count >= k)
          return a;
        la++;
        lb++;
      }
    }
  }
  
  /**
   * use binary search to reduce the search space
   * maintain an invariant: i+j = k-1
   * if (B[j-1] < A[i] < B[j]), then return A[i] as kth smallest element
   * else if (A[i-1] < B[j] < A[i]), then return B[j]
   * else eliminate part of A and B for search
   * Time: O(log(m) + log(n))  
   * @param A
   * @param B
   * @param k
   * @return
   */
  public static int kth3(int[] A, int[] B, int k){
    int m = A.length;
    int n = B.length;
    assert(m >= 0 || n >= 0);
    assert(k > 0 && k <= m + n);
    return findKth(A, 0, m-1, B, 0, n-1, k);
  }
  
  private static int findKth(int[] A, int startA, int endA, int[] B, int startB, int endB, int k){
    int m = endA - startA + 1;
    int n = endB - startB + 1;
    
    int i = Math.max(0, (int) ((1.0 * m * (k - 1)) / (m + n)));
    int j = k - 1 - i;
    i += startA;
    j += startB;
    
    if (startA > endA)
      return B[j];
    if (startB > endB)
      return A[i];
    
    int Ai_1 = i <= startA ? Integer.MIN_VALUE : A[i-1];
    int Ai = i > endA ? Integer.MAX_VALUE : A[i];
    int Bj_1 = j <= startB ? Integer.MIN_VALUE : B[j-1];
    int Bj = j > endB ? Integer.MAX_VALUE : B[j];
    
    if (Bj_1 < Ai && Ai < Bj)
      return Ai;
    else if (Ai_1 < Bj && Bj < Ai)
      return Bj;
    
    if (Ai < Bj)
      return findKth(A, i+1, endA, B, startB, j, k-i+startA-1);
    else
      return findKth(A, startA, i, B, j+1, endB, k-j+startB-1);
  }
  
  /**
   * iterative solution of O(log(m) + log(n))
   * @param A
   * @param B
   * @param k
   * @return
   */
  public static int kth4(int[] A, int[] B, int k) {
    int n = A.length;
    int m = B.length;

    if (k > m + n)
      return -1;
    int al = 0, ar = n - 1;
    int bl = 0, br = m - 1;

    while (true) {
      n = ar - al + 1;
      m = br - bl + 1;
      int i = Math.max(0, (int) ((1.0 * n * (k - 1)) / (m + n)));
      int j = k - 1 - i;
      i += al;
      j += bl;
      if (al > ar)
        return B[j];

      if (bl > br)
        return A[i];

      int ai = (i > ar) ? Integer.MAX_VALUE : A[i];
      int ai_1 = (i <= al) ? Integer.MIN_VALUE : A[i-1];
      int bj = (j > br) ? Integer.MAX_VALUE : B[j];
      int bj_1 = (j <= bl) ? Integer.MIN_VALUE : B[j-1];

      if (ai_1 < bj && bj < ai) {
        return bj;
      } else if (bj_1 < ai && ai < bj) {
        return ai;
      }

      if (ai < bj) {
        k -= i - al + 1;
        al = i + 1;
        br = j;
      } else {
        k -= j - bl + 1;
        ar = i;
        bl = j + 1;
      }
    }
  }
  
  public static void main(String[] args){
    int[] A = {1,2,3,4,5};
    int[] B = {4,5,6,7,8};
    System.out.println(KthSmallestInTwoSortedArray.kth(A, B, 3));
    System.out.println(KthSmallestInTwoSortedArray.kth(A, B, 5));
    System.out.println(KthSmallestInTwoSortedArray.kth(A, B, 8));
    
    System.out.println(KthSmallestInTwoSortedArray.kth2(A, B, 3));
    System.out.println(KthSmallestInTwoSortedArray.kth2(A, B, 5));
    System.out.println(KthSmallestInTwoSortedArray.kth2(A, B, 8));
    
    System.out.println(KthSmallestInTwoSortedArray.kth3(A, B, 3));
    System.out.println(KthSmallestInTwoSortedArray.kth3(A, B, 5));
    System.out.println(KthSmallestInTwoSortedArray.kth3(A, B, 8));
    
    System.out.println(KthSmallestInTwoSortedArray.kth4(A, B, 3));
    System.out.println(KthSmallestInTwoSortedArray.kth4(A, B, 5));
    System.out.println(KthSmallestInTwoSortedArray.kth4(A, B, 8));
  }
  
}
