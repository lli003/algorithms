package lc;
/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * @author lli003
 *
 */
public class ReverseInteger {
  
  public int reverse(int x){
    boolean isPos = x > 0 ? true : false;
    int temp = Math.abs(x);
    int result = 0;
    
    while (temp > 0){
      result = result * 10 + temp%10;
      temp = temp / 10;
    }
    
    if (isPos)
      return result;
    else
      return -1 * result;
  }
}
