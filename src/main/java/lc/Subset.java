package lc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author leili
 *
 */
public class Subset {

  public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (S == null || S.length == 0)
      return result;
    Arrays.sort(S);
    ArrayList<Integer> ret = new ArrayList<Integer>();
    result.add(ret);
    subsetHelper(0, S, result, ret);
    return result;
  }

  private void subsetHelper(int idx, int[] S,
      ArrayList<ArrayList<Integer>> result, ArrayList<Integer> ret) {
    for (int i = idx; i < S.length; i++) {
      ret.add(S[i]);
      result.add(new ArrayList<Integer>(ret));
      if (i < S.length - 1)
        subsetHelper(i + 1, S, result, ret);
      ret.remove(ret.size() - 1);
    }
  }

}
