package basic.sort;

public class Quicksort {
  
  /**
   * divide and conquer
   * @param num
   * @param left
   * @param right
   */
  public void quicksort(int[] num, int left, int right){
    if (left < right){
      int pivotIdx = left + (int) (Math.random() * (right - left));
      pivotIdx = partition(num, left, right, pivotIdx);
      quicksort(num, left, pivotIdx - 1);
      quicksort(num, pivotIdx + 1, right);
    }
  }
  
  /**
   * partition the array
   * given a pivot index, rearrange the array as the values less than the pivot,
   * followed by the pivot, followed by the values greater than or equal to the pivot
   * @param num
   * @param left
   * @param right
   * @param pivot
   * @return
   */
  private int partition(int[] num, int left, int right, int pivot){
    int pivotVal = num[pivot];
    int storeIdx = left;
    swap(num, pivot, right);
    for (int i = left; i < right; i++){
      if (num[i] < pivotVal){
        swap(num, i, storeIdx);
        storeIdx++;
      }
    }
    swap(num, storeIdx, right);
    return storeIdx;
  }
  
  private void swap(int[] num, int idx1, int idx2){
    int temp = num[idx1];
    num[idx1] = num[idx2];
    num[idx2] = temp;
  }
  
  public static void main(String[] args){
    int[] num = {1,3,8,2,4,2,6,7};
    Quicksort qs = new Quicksort();
    qs.quicksort(num, 0, num.length-1);
    for (int i = 0; i < num.length; i++)
      System.out.print(num[i] + " ");
  }

}
