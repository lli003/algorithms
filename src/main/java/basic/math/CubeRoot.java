package basic.math;

public class CubeRoot {
  
  /**
   * binary search
   * @param num
   * @return
   */
  public static int cbrt(int num){
    int start = 0, end = num;
    int re = 0;
    while (start < end){
      int mid = start + (end - start)/2;
      re = mid * mid * mid;
      if (re == num)
        return mid;
      else if (re < num)
        start = mid;
      else
        end = mid;
    }
    if (start * start * start == num)
      return start;
    return -1;
  }
  
  public static double cbrtNewton(double n, double x){
    double xnew;         //Next guess of cube root by Newton method
    double err= 1;       //Relative difference between x and xnew;
    
    final double tol= 0.0001;  //CONSTANT error tolerance
    
    /* newton's method. b = a - ((a^3-n)/(3a^2)) where a is a guess*/
    while (err > tol) {
      xnew= x - (Math.pow(x,3) - n)/(3*x*x);
      err= Math.abs((xnew-x)/x);
      x= xnew;
    }
    
    return x;
  }
  
  public static void main(String[] args){
    System.out.println(CubeRoot.cbrtNewton(27, Math.random()*3));
    System.out.println(CubeRoot.cbrtNewton(1000000000, Math.random()*1000));
  }

}
