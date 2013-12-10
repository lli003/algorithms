package basic.math;

public class IntegerToString {
  
  public static String itoa(int val){
    StringBuffer sb = new StringBuffer();
    while (val > 0){
      int rem = val % 10;
      sb.insert(0, rem);
      val = val / 10;
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
  
  public static void main(String[] args){
    System.out.println(IntegerToString.itoa(0));
    System.out.println(IntegerToString.itoa(101));
    System.out.println(IntegerToString.itoa(2345));
  }

}
