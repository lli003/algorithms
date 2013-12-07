package basic.bit;

/**
 * given a 64bit integer, swap the bits at indices i and j of this integer
 * @author leili
 *
 */
public class Swap {
  
  /**
   * check if the ith and jth bits are different
   * if so, swap
   * @param x
   * @param i
   * @param j
   * @return
   */
  public static long swapBits(long x, int i, int j){
    if (((x >> i) & 1) != ((x >> j) & 1)){
      x ^= (1 << i) | (1 << j);
    }
    return x;
  }

}
