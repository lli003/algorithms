package basic.bit;

/**
 * the parity of a sequence of bits is 1 if the number of 1s in the sequence is odd, or 0 otherwise
 * @author leili
 *
 */
public class Parity {
  
  /**
   * count the number of 1s in a number
   * @param num
   * @return
   */
  public static short parity(long num){
    short r = 0;
    while (num != 0){
      r ^= (num & 1);
      num >>= 1;
    }
    return r;
  }
  
  /**
   * remove the least significant bit from the number
   * @param num
   * @return
   */
  public static short parity2(long num){
    short r = 0;
    while (num != 0){
      r ^= 1;
      /* remove the least significant bit from the number. */
      num &= (num-1);
    }
    return r;
  }
  
  public static void main(String[] args){
    System.out.println(Parity.parity(1));
    System.out.println(Parity.parity(2));
    System.out.println(Parity.parity2(3));
    System.out.println(Parity.parity2(16));
  }

}
