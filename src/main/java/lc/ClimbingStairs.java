package lc;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author lli003
 *
 */
public class ClimbingStairs {
  
  /**
   * one-dimensional dp
   * each step i depends on the solution of the step i-1 and i-2
   * @param n
   * @return
   */
  public int climbStairs(int n){
    if (n < 2)
      return n;
    
    int n1 = 1, n2 = 1;
    for (int i = 2; i <= n; i++){
      int temp = n2;
      n2 += n1;
      n1 = temp;
    }
    
    return n2;
  }

}
