package lc;

/**
 * Given a number represented as an array of digits, plus one to the number.
 * @author lli003
 *
 */
public class PlusOne {
  
  public int[] plusOne(int[] digits){
    if (digits.length == 0){
      int[] result = {1};
      return result;
    }
    
    int[] result = new int[digits.length];
    int carry = 0;
    int sum = 1;
    for (int i = digits.length - 1; i >= 0; i--){
      sum = sum + carry + digits[i];
      carry = sum / 10;
      result[i] = sum % 10;
      sum = 0;
    }
    
    if (carry != 0){
      int newResult[] = new int[result.length + 1];
      newResult[0] = carry;
      for (int i = 1; i < newResult.length; i++){
        newResult[i] = result[i-1];
      }
      return newResult;
    }
    
    return result;
  }

}
