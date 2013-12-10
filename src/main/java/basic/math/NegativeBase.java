package basic.math;

/**
 * convert a decimal to the one based on a negative base
 * @author leili
 *
 */
public class NegativeBase {
  
  public static void convert(int decimal, int base){
    assert(decimal >= 0);
    
    StringBuffer sb = new StringBuffer("");
    while (decimal != 0){
      int result = decimal / base;
      int remainder = decimal % base;
      if (remainder < 0){
        result++;
        remainder = decimal - base * result;
      }
      decimal = result;
      sb.insert(0, remainder);
    }
    System.out.println(sb.toString());
  }
  
  public static void main(String[] args){
    NegativeBase.convert(10, -2);
  }

}
