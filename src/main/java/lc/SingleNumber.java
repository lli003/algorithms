package lc;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Time requirement: O(n)
 * Space requirement: Constant
 * @author lli003
 *
 */
public class SingleNumber {
  
  /**
   * the XOR of two identical number is 0
   * @param A
   * @return
   */
  public int singleNumber(int[] A){
    int temp = 0;
    for (int i = 0; i < A.length; i++)
      temp ^= A[i];
    return temp;
  }
}
