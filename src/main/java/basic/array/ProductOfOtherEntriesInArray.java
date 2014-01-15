package basic.array;

public class ProductOfOtherEntriesInArray {

  /**
   * using division
   * @param A
   * @return
   */
  public static int[] productArray(int[] A) {
    assert (A != null);

    if (A.length == 0)
      return A;

    int countZeros = 0;
    double product = 1.0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0)
        countZeros++;
      else
        product *= A[i];
    }

    int[] B = new int[A.length];
    if (countZeros > 1) {
      return B;
    }

    for (int i = 0; i < B.length; i++) {
      if (A[i] == 0) {
        B[i] = (int) product;
      } else {
        if (countZeros == 1) {
          B[i] = 0;
        } else {
          B[i] = (int) product / A[i];
        }
      }
    }
    return B;
  }
  
  /**
   * without division
   * @param A
   * @return
   */
  public static int[] productArray2(int[] A){
    assert(A != null);
    if (A.length == 0)
      return A;
    
    int[] leftP = new int[A.length];
    int product = 1;
    leftP[0] = 1;
    for (int i = 1; i < A.length; i++){
      leftP[i] = product * A[i-1];
      product = product * A[i-1];
    }
    
    product = 1;
    for (int i = A.length - 1; i >= 0; i--){
      leftP[i] = leftP[i] * product;
      product *= A[i];
    }
    return leftP;
  }

  public static void main(String[] args) {
    int[] A = {};
    int[] A1 = { 0, 0, 0, 0 };
    int[] A2 = { 0, 1, 10, 0, 12 };
    int[] A3 = { 1, 2, 3, 4, 5 };
    int[] A4 = { 0, 1, 2, 3, 4 };
    
    int[] B = ProductOfOtherEntriesInArray.productArray2(A1);
    for (Integer i : B)
      System.out.println(i);
  }

}
