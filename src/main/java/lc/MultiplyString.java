package lc;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 * @author leili
 *
 */
public class MultiplyString {
  
  public String multiply(String num1, String num2){
    assert(num1 != null && num2 != null);
    
    /* reverse the strings to start from the lowest bit. */
    num1 = new StringBuilder(num1).reverse().toString();
    num2 = new StringBuilder(num2).reverse().toString();
    
    /* multiple single digits of each string. */
    int[] digits = new int[num1.length() + num2.length()];
    for (int i = 0; i < num1.length(); i++){
        int a = num1.charAt(i) - '0';
        for (int j = 0; j < num2.length(); j++){
            int b = num2.charAt(j) - '0';
            digits[i+j] += a * b;
        }
    }
    
    /* deal with carry one by one bit. */
    StringBuilder sb = new StringBuilder();
    int digit = 0;
    int carry = 0;
    for (int i = 0; i < digits.length; i++){
        digit = digits[i] % 10;
        carry = digits[i] / 10;
        if (i < digits.length - 1)
            digits[i+1] += carry;
        sb.insert(0, digit);
    }
    
    /* remove extra zero from the left of the string. */
    while (sb.length() > 0 && sb.charAt(0) == '0')
        sb.deleteCharAt(0);
    
    return sb.length() == 0 ? "0" : sb.toString();
  }

}
