package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
   The solution set must not contain duplicate triplets.
   For example, given array S = {-1 0 1 2 -1 -4},
   A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 * 
 * @author lli003
 *
 */
public class ThreeSum {
  
  /**
   * two pointers and binary search on data within the range of two pointers
   * time: O(n^2lgn)
   * @param num
   * @return
   */
  public ArrayList<ArrayList<Integer>> threeSum(int[] num){
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (num.length < 3)
      return result;
    
    Arrays.sort(num);
    // use hashset to store unique solutions
    Set<ArrayList<Integer>> uniqueSols = new HashSet<ArrayList<Integer>>();
    
    // two pointers
    for (int i = 0; i < num.length - 2; i++){
      for (int j = num.length - 1; j >= i+2; j--){
        int target = -1 * (num[i] + num[j]);
        // binary search the target: c = -a-b
        int tIdx = findTarget(num, i+1, j-1, target);
        if (tIdx != -1){
          ArrayList<Integer> sol = new ArrayList<Integer>();
          sol.add(num[i]);
          sol.add(num[tIdx]);
          sol.add(num[j]);
          uniqueSols.add(sol);
        }
      }
    }
    
    return new ArrayList<ArrayList<Integer>>(uniqueSols);
  }
  
  /**
   * binary search to find the target within an array 
   * @param num
   * @param start
   * @param end
   * @param target
   * @return
   */
  private int findTarget(int[] num, int start, int end, int target){
    int mid = 0;
    while(start < end){
      mid = (start + end)/2;
      if (num[mid] == target)
        return mid;
      else if (num[mid] < target)
        start = mid + 1;
      else
        end = mid - 1;
    }
    if (num[start] == target)
      return start;
    else
      return -1;
  }

}
