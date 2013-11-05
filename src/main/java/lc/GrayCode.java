package lc;

import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

 * @author lli003
 *
 */
public class GrayCode {
  
  /**
   * the gray code of a number is obtained by XOR of itself and itself >> 1
   * @param n
   * @return
   */
  public ArrayList<Integer> grayCode(int n){
    int size = 1;
    for (int i = 1; i <= n; i++)
      size *= 2;
    
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < size; i++){
      result.add(i ^ (i >> 1));
    }
    return result;
  }

}
