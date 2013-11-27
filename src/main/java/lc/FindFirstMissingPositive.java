package lc;

/**
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 * @author lli003
 *
 */
public class FindFirstMissingPositive {
  
  public int firstMissingPositive(int[] A){
    assert(A != null);
    
    int i = 0;
    int n = A.length;
    while (i < n){
      if (A[i] - 1 != i && A[i] > 0 && A[i] <= n && A[A[i]-1] != A[i]){
        int temp = A[A[i] - 1];
        A[A[i] - 1] = A[i];
        A[i] = temp;
      } else
        i++;
    }
    
    for (i = 0; i < n; i++){
      if (A[i] - 1 != i)
        return i+1;
    }
    return n+1;
  }

}
