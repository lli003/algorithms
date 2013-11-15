package lc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 * @author leili
 *
 */
public class CombinationSum {

  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
      int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (candidates == null || candidates.length == 0 || target <= 0)
      return result;
    Arrays.sort(candidates);
    int[] times = new int[candidates.length];
    combinationSumHelper(0, candidates, target, result, times);
    return result;
  }

  private void combinationSumHelper(int idx, int[] candidates, int target,
      ArrayList<ArrayList<Integer>> result, int[] times) {
    if (target < 0 || (idx == candidates.length && target != 0))
      return;
    if (target == 0) {
      ArrayList<Integer> ret = new ArrayList<Integer>();
      for (int i = 0; i < idx; i++) {
        for (int j = 1; j <= times[i]; j++) {
          ret.add(candidates[i]);
        }
      }
      result.add(ret);
      return;
    }
    for (int i = 0; i <= target / candidates[idx]; i++) {
      times[idx] = i;
      combinationSumHelper(idx + 1, candidates, target - candidates[idx] * i,
          result, times);
    }
  }

}
