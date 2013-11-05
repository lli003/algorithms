package lc;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * @author lli003
 *
 */
public class RemoveDumplicatesFromSortedArray {
  
  /**
   * if there is a duplicate, swap the duplicate with the following elements
   * @param A
   * @return
   */
  public int removeDuplicates(int[] A){
    if (A.length < 2)
      return A.length;
    
    int l = A.length;
    int cur = A[0];
    for (int i = 1; i < l; ){
      // check duplicate
      while (A[i] == cur && i < l){
        // iteratively swap duplicate to the end of the array
        for (int j = i; j < l-1; j++){
          int temp = A[j];
          A[j] = A[j+1];
          A[j+1] = temp;
        }
        l--;
      }
      cur = A[i];
      i++;
    }
    return l;
  }

}
