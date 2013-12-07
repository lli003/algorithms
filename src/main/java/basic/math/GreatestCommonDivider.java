package basic.math;

/**
 * compute the greatest common divider without using multiplication, division or modulus operator
 * @author leili
 *
 */
public class GreatestCommonDivider {
  
  public static int GCD(int x, int y){
    if (x == 0)
      return y;
    else if (y == 0)
      return x;
    else if (!isOdd(x) && !isOdd(y)){
      x >>= 1;
      y >>= 1;
      return GCD(x, y) << 1;
    } else if (!isOdd(x) && isOdd(y)){
      return GCD(x >> 1, y);
    } else if (isOdd(x) && !isOdd(y)){
      return GCD(x, y >> 1);
    } else if (x <= y){
      return GCD(x, y-x);
    } else
      return GCD(x-y, y);
  }
  
  public static boolean isOdd(int x){
    return (x & 1) != 0;
  }
  
  public static void main(String[] args){
    System.out.println(GreatestCommonDivider.GCD(2,3));
    System.out.println(GreatestCommonDivider.GCD(2,6));
    System.out.println(GreatestCommonDivider.GCD(64,112));
  }

}
