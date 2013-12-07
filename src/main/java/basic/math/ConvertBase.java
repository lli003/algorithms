package basic.math;

/**
 * base conversion
 * The input is a string of base b1
 * The output is a string of base b2
 * @author leili
 *
 */
public class ConvertBase {
  
  /**
   * convert a string of base b1 to a string of base b2
   * assume the integer is a positive integer
   * @param num
   * @param b1 -- original base
   * @param b2 -- expected base
   * @return
   */
  public static String convert(String num, int b1, int b2){
    int val = 0;
    for (int i = 0; i < num.length(); i++){
      val *= b1;
      val += Character.isDigit(num.charAt(i)) ? num.charAt(i) - '0' : num.charAt(i) - 'A' + 10;
    }
    
    StringBuffer result = new StringBuffer("");
    while (val > 0){
      int r = val % b2;
      result.insert(0, r >= 10 ? 'A' + r - 10 : r);
      val /= b2;
    }
    
    return result.toString().length() == 0 ? "0" : result.toString();
  }
  
  public static void main(String[] args){
    System.out.println(ConvertBase.convert("10A", 16, 10));
    System.out.println(ConvertBase.convert("10A", 16, 2));
  }

}
