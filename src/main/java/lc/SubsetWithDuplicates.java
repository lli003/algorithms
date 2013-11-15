package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * @author leili
 *
 */
public class SubsetWithDuplicates {

  public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (num == null || num.length == 0)
      return result;
    Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
    ArrayList<Integer> ret = new ArrayList<Integer>();
    set.add(ret);
    Arrays.sort(num);
    subsetsHelper(0, num, set, ret);
    return new ArrayList<ArrayList<Integer>>(set);
  }

  private void subsetsHelper(int idx, int[] num, Set<ArrayList<Integer>> set,
      ArrayList<Integer> ret) {
    for (int i = idx; i < num.length; i++) {
      ret.add(num[i]);
      set.add(new ArrayList<Integer>(ret));
      if (i < num.length - 1)
        subsetsHelper(i + 1, num, set, ret);
      ret.remove(ret.size() - 1);
    }
  }

}
