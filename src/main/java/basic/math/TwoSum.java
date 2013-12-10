package basic.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum problem
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: [2,7]
 * @author lli003
 *
 */
public class TwoSum {
  
  /**
   * sort the array and maintain two pointers to get the result
   * @param num
   * @return
   */
  public int[] twoSum(int[] num, int target){
    if (num.length < 2)
      return new int[2];
    
    Arrays.sort(num);
    int[] result = new int[2];
    
    int i = 0, j = num.length - 1;
    while (i < j){
      if (num[i] + num[j] == target){
        result[0] = num[i];
        result[1] = num[j];
        return result;
      } else if (num[i] + num[j] < target){
        i++;
      } else
        j--;
    }
    return result;
  }
  
  public int[] twoSum2(int[] num, int target){
    if (num.length < 2)
      return new int[2];
    
    int[] result = new int[2];
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    for (int i = 0; i < num.length; i++){
      if (map.containsKey(num[i])){
        result[0] = num[map.get(num[i])];
        result[1] = num[i];
        return result;
      } else{
        map.put(target - num[i], i);
      }
    }
    return result;
  }
  
  public static void main(String[] args){
    int[] num = {1, 3, 6, 2, 4, 10, 11};
    int target = 10;
    TwoSum ts = new TwoSum();
    int[] result = ts.twoSum2(num, target);
    System.out.println(result[0] + " " + result[1]);
  }

}
