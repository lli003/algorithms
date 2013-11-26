package lc;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * @author lli003
 *
 */
public class DivideTwoIntegers {
  
  public int divide(int dividend, int divisor){
    boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
    long a = Math.abs((long) dividend);
    long b = Math.abs((long) divisor);
    
    int result = 0;
    while (a >= b){
        long c = b;
        /* speed up using c <<= 1, meaning each time double the divisor. */
        for (int i = 0; a >= c; i++, c <<= 1){
            a -= c;
            result += 1 << i;
        }
    }
    return neg ? (-result) : result;
  }

}
