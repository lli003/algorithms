package other;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * For given set of natural number, suppose we can negate some number. 
 * Find what all number we should negate such that sum of all number (after negating some number) is zero. 
 * For ex: {1,2,3} return {-1, -2} or {-3}, {1,2,3,4} return {-1,-4} or {-2,-3}. 
 * 1st check if such number in given set exist or not. If not return empty array else return numbers.
 * @author leili
 *
 */
public class SumZeroByNegatingNumber {
  
  public static ArrayList<ArrayList<Integer>> negateSum(int[] num){
    assert(num != null);
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (num.length == 0)
        return result;
    
    Arrays.sort(num);
    int total = 0;
    for (int i = 0; i < num.length; i++){
      total += num[i];
    }
    
    /* find sublist of numbers that sum to total/2. */
    ArrayList<Integer> res = new ArrayList<Integer>();
    scan(num, total/2, 0, 0, res, result);
    return result;
  }
  
  private static void scan(int[] num, int half, int sum, int start, 
      ArrayList<Integer> res, ArrayList<ArrayList<Integer>> result){
    if (sum == half){
      ArrayList<Integer> tmp = new ArrayList<Integer>(res);
      result.add(tmp);
      return;
    }
    
    if (sum > half)
      return;
    
    for (int i = start; i < num.length; i++){
      ArrayList<Integer> tmp = new ArrayList<Integer>(res);
      tmp.add(num[i]);
      scan(num, half, sum + num[i], i+1, tmp, result);
    }
  }
  
  public static void main(String[] args){
    int[] num = {1,2,3};
    ArrayList<ArrayList<Integer>> result = SumZeroByNegatingNumber.negateSum(num);
    for (ArrayList<Integer> res : result){
      for (Integer i : res)
        System.out.print(i + " ");
      System.out.println();
    }
  }

}
