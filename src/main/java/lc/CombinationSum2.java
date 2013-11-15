package lc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 * @author leili
 *
 */
public class CombinationSum2 {

  public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (num == null || num.length == 0 || target < 0)
      return result;
    Arrays.sort(num);
    int[] times = new int[num.length];
    combinationSum2Helper(0, num, target, result, times);
    return result;
  }

  private void combinationSum2Helper(int idx, int[] num, int target,
      ArrayList<ArrayList<Integer>> result, int[] times) {
    if (target < 0 || (idx == num.length && target != 0))
      return;
    if (target == 0) {
      ArrayList<Integer> ret = new ArrayList<Integer>();
      for (int i = 0; i < idx; i++) {
        for (int j = 1; j <= times[i]; j++) {
          ret.add(num[i]);
        }
      }
      result.add(ret);
      return;
    }
    int time = 0;
    int idxCur = idx;
    while (idxCur < num.length && num[idxCur] == num[idx]) {
      time++;
      idxCur++;
    }
    for (int i = 0; i <= time; i++) {
      times[idx] = i;
      combinationSum2Helper(idxCur, num, target - num[idx] * i, result, times);
    }
  }

}
