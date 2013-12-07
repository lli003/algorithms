package basic.bit;

/**
 * given a number, reverse bits
 * @author leili
 *
 */
public class Reverse {
  
  public static int reverse(int x){
    int b = 0;
    while (x != 0){
      b <<= 1;
      b |= (x & 1);
      x >>= 1;
    }
    return b;
  }
  
  public static void main(String[] args){
    System.out.println(Reverse.reverse(1));
    System.out.println(Reverse.reverse(2));
    System.out.println(Reverse.reverse(3));
    System.out.println(Reverse.reverse(4));
    System.out.println(Reverse.reverse(5));
  }

}
