package lc;

/**
 * Implement int sqrt(int x).

Compute and return the square root of x.
 * @author lli003
 *
 */
public class Sqrt {
  
  /**
   * binary search
   * @param x
   * @return
   */
  public int sqrt(int x){
    if (x < 0)
      return -1;
    
    if (x == 0 || x == 1)
      return x;
    
    int start = 0, end = x;
    while (end - start > 1){
      int mid = start + (end - start) / 2;
      if (mid == x/mid)
        return mid;
      else if (mid > x/mid)
        end = mid;
      else
        start = mid;
    }
    
    return start;
  }

}
