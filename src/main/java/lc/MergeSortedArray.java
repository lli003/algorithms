package lc;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * You may assume that A has enough space to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * @author lli003
 *
 */
public class MergeSortedArray {
  
  public void merge(int A[], int m, int B[], int n){
    if (n == 0)
      return;
    if (m == 0){
      for (int i = 0; i < n; i++)
        A[i] = B[i];
      return;
    }
    
    int l = m + n;
    for (int i = m - 1, j = n - 1; i >= 0 || j >= 0; ){
      int valA = i >= 0 ? A[i] : Integer.MIN_VALUE;
      int valB = j >= 0 ? B[j] : Integer.MIN_VALUE;
      if (valA > valB){
        int temp = A[i];
        A[i] = A[l-1];
        A[l-1] = temp;
        l--;
        i--;
      } else if (valB > valA){
        A[l-1] = valB;
        l--;
        j--;
      } else {
        int temp = A[i];
        A[i] = A[l-1];
        A[l-1] = temp;
        l--;
        i--;
        A[l-1] = valB;
        l--;
        j--;
      }
    }
    return;
  }
  
}
