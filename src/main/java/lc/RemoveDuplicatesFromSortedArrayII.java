package lc;

/**
 * The duplicates of an element can be allowed at most twice
 * @author leili
 *
 */
public class RemoveDuplicatesFromSortedArrayII {

  public int removeDuplicates(int[] A) {
    if (A.length < 2)
      return A.length;

    int l = A.length;
    int cur = A[0];
    for (int i = 1; i < l;) {
      int count = 0;
      while (i < l && A[i] == cur) {
        count++;
        if (count == 2) {
          for (int j = i; j < l - 1; j++) {
            int temp = A[j];
            A[j] = A[j + 1];
            A[j + 1] = temp;
          }
          l--;
          count--;
        } else {
          cur = A[i];
          i++;
        }
      }
      if (i < l) {
        cur = A[i];
        i++;
      }
      count = 0;
    }
    return l;
  }

}
