package lc;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author leili
 *
 */
public class RemoveElement {
  
  /**
   * scan the list
   * if matched, swap the element with the one not matched from the tail of the array
   * @param A
   * @param elem
   * @return
   */
  public int removeElement(int[] A, int elem){
    if (A.length == 0)
      return 0;
    if (A.length == 1 && A[0] == elem)
      return 0;
    
    int l = A.length;
    for (int i = 0; i < l; i++){
      if (A[i] == elem){
        
        // skip the matched elements from the tail
        while (l-1 > 0 && A[l-1] == elem)
          l--;
        
        // swap the elements
        if (l-1 >= i){
          int temp = A[i];
          A[i] = A[l-1];
          A[l-1] = temp;
          l--;
        }
      }
    }
    return l;
  }
}
