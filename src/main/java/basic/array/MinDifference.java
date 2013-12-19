package basic.array;

public class MinDifference {
  
  public static int minDiff(int[] A, int[] B){
    int res = Integer.MAX_VALUE;
    int i = 0, j = 0;
    while (i < A.length && j < B.length){
      if (A[i] <= B[j]){
        res = Math.min(res, B[j]-A[i]);
        i++;
      } else {
        res = Math.min(res, A[i] - B[j]);
        j++;
      }
    }
    return res;
  }
  
  public static void main(String[] args){
    int[] A = {0,1,2,3,4,9};
    int[] B = {5,7,8,10};
    
    System.out.println(MinDifference.minDiff(A, B));
  }

}
