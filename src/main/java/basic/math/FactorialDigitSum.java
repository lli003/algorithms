package basic.math;

import java.math.BigInteger;

public class FactorialDigitSum {
  
  public int facSum(int n){
    int max = 0;
    double sum = 0.0;
    
    /* get the maximum digit count of the factorial. */
    for (int i = 2; i <= n; i++){
      sum += Math.log10(i);
    }
    max = (int)sum + 1;
    
    int[] cal = new int[max+1];
    cal[0] = max;
    cal[1] = 1;
    int carry = 0; 
    
    /* multiple from 2 to n. */
    for (int k = 2; k <= n; k++){
      carry = 0;
      for (int i = 1; i <= max; i++){
        cal[i] = cal[i] * k + carry;
        carry = cal[i] / 10;
        cal[i] = cal[i] % 10;
      }
    }
    
    int facSum = 0;
    for (int i = 1; i <= max; i++)
      facSum += cal[i];
    return facSum;
  }
  
  public BigInteger fac(int n){
    BigInteger sum = BigInteger.valueOf(1);
    int i = 1;
    while ( i <= n){
      sum = sum.multiply(BigInteger.valueOf(i));
      i++;
    }
    return sum;
  }
  
  public int facSum2(BigInteger sum){
    String res = sum.toString();
    int total = 0;
    for (int i = 0; i < res.length(); i++){
      total += Integer.valueOf(res.charAt(i) + "");
    }
    return total;
  }
  
  public static void main(String[] args){
    FactorialDigitSum fd = new FactorialDigitSum();
    System.out.println(fd.facSum(1));
    System.out.println(fd.facSum(5));
    System.out.println(fd.facSum(10));
    System.out.println(fd.facSum(100));
    System.out.println(fd.facSum(200));
    System.out.println(fd.facSum2(fd.fac(1)));
    System.out.println(fd.facSum2(fd.fac(5)));
    System.out.println(fd.facSum2(fd.fac(10)));
    System.out.println(fd.facSum2(fd.fac(100)));
    System.out.println(fd.facSum2(fd.fac(200)));
  }

}
