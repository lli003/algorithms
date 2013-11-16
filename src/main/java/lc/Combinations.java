package lc;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author leili
 *
 */
public class Combinations {

  public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (n == 0 || k == 0)
      return result;
    ArrayList<Integer> ret = new ArrayList<Integer>();
    combineHelper(1, n, k, result, ret);
    return result;
  }

  private void combineHelper(int idx, int n, int k,
      ArrayList<ArrayList<Integer>> result, ArrayList<Integer> ret) {
    if (k == 0) {
      result.add(new ArrayList<Integer>(ret));
      return;
    }
    if (k > 0 && idx <= n) {
      ret.add(idx);
      combineHelper(idx + 1, n, k - 1, result, ret);
      ret.remove(ret.size() - 1);
      combineHelper(idx + 1, n, k, result, ret);
    }
  }

}
