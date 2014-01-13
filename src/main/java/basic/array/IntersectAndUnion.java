package basic.array;

import java.util.ArrayList;
import java.util.List;

/**
 * given two sorted arrays, find their intersection and union
 * @author leili
 *
 */
public class IntersectAndUnion {
  
  public int[] union(int[] A, int[] B){
    assert(A != null && B != null);
    if (A.length == 0)
      return B;
    if (B.length == 0)
      return A;
    
    List<Integer> list = new ArrayList<Integer>();
    int al = 0, bl = 0;
    while (al < A.length || bl < B.length){
      int a = al < A.length ? A[al] : Integer.MAX_VALUE;
      int b = bl < B.length ? B[bl] : Integer.MAX_VALUE;
      if (a < b) {
        list.add(a);
        al++;
      } else if (a > b){
        list.add(b);
        bl++;
      } else {
        list.add(a);
        al++;
        bl++;
      }
    }
    int[] U = new int[list.size()];
    for (int i = 0; i < list.size(); i++)
      U[i] = list.get(i);
    return U;
  }
  
  public int[] intersect(int[] A, int[] B){
    assert(A != null && B != null);
    if (A.length == 0 || B.length == 0 || A[A.length - 1] < B[0] || B[B.length - 1] < A[0])
      return new int[0];
    
    List<Integer> list = new ArrayList<Integer>();
    int al = 0, bl = 0;
    while (al < A.length || bl < A.length){
      int a = al < A.length ? A[al] : Integer.MAX_VALUE;
      int b = bl < B.length ? B[bl] : Integer.MAX_VALUE;
      if (a == b){
        list.add(a);
        al++;
        bl++;
      } else if (a < b){
        al++;
      } else {
        bl++;
      }
    }
    int[] I = new int[list.size()];
    for (int i = 0; i < list.size(); i++)
      I[i] = list.get(i);
    return I;
  }
  
  public static void main(String[] args){
    IntersectAndUnion iu = new IntersectAndUnion();
    int[] A = {1,2,3,4,5};
    int[] B = {4,5,6,7,8};
    int[] U = iu.union(A, B);
    for (Integer i : U)
      System.out.print(i + " ");
    System.out.println();
    int[] I = iu.intersect(A, B);
    for (Integer i : I)
      System.out.print(i + " ");
  }

}
