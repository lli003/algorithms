package other;

/**
 * Given an integer array, find the index range of a target integer value;
 * if the target value doesn't exist in the array, then return -1
 * @author leili
 *
 */
public class SearchForARange {
  
  public int[] searchForRange(int[] num, int target){
    int[] res = new int[2];
    if (num.length == 0){
      res[0] = -1;
      res[1] = -1;
      return res;
    }
    
    /* search for the start index. */
    int start = -1;
    if (num[0] == target){
      start = 0;
    } else {
      for (int i = 1; i < num.length - 1; i++) {
        if (num[i] != target && num[i + 1] == target) {
          start = i + 1;
          break;
        }
      }
    }
    
    /* search for the end index. */
    int end = -1;
    if (num[num.length - 1] == target){
      end = num.length - 1;
    } else {
      for (int i = 0; i < num.length - 1; i++) {
        if (num[i] == target && num[i + 1] != target) {
          end = i;
          break;
        }
      }
    }
    
    res[0] = start;
    res[1] = end;
    
    return res;
  }
  
  public static void main(String[] args){
    int[] num = {1,1,1,2,3,4,5,5,5,5,6,7,8,8,8};
    SearchForARange sf = new SearchForARange();
    int[] result = sf.searchForRange(num, 8);
    System.out.println(result[0] + " " + result[1]);
  }

}
