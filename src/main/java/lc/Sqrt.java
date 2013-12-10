package lc;

/**
 * Implement int sqrt(int x).
 * and double sqrt(double x)

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
  public static int sqrt(int x){
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
  
  /**
   * newton's method
   * @param x
   * @return
   */
  public static double sqrt(double x){
    if (x < 0)
      return Double.NaN;
    
    double eps = 1E-15;
    
    double t = x;
    while (Math.abs(t - x/t) > eps*t){
      t = (x/t + t) / 2;
    }
    return t;
  }
  
  public static void main(String[] args){
    System.out.println(Sqrt.sqrt(1000000.0));
  }

}
