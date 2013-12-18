package lc;

public class Pow {
  
  /**
   * recursive solution
   * @param x
   * @param n
   * @return
   */
  public double pow(double x, int n){
    if (n > 0)
      return power(x, n);
    else
      return 1/power(x, -n);
  }
  
  private double power(double x, int n){
    if (n == 0)
      return 1.0;
    double p = power(x, n/2);
    if (n % 2 == 0)
      return p * p;
    else
      return p * p * x;
  }

}
