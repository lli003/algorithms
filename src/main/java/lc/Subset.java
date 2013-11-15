package lc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author leili
 * 
 */
public class Subset {

  /**
   * if not reaching the end of array, then do dfs
   * @param S
   * @return
   */
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

  /**
   * using a vector of indicator to label visited position
   * @param S
   * @return
   */
  public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (S == null || S.length == 0)
      return result;
    Arrays.sort(S);
    boolean[] visit = new boolean[S.length];
    subsetHelper2(0, S, result, visit);
    return result;
  }

  private void subsetHelper2(int idx, int[] S,
      ArrayList<ArrayList<Integer>> result, boolean[] visit) {
    if (idx == S.length) {
      ArrayList<Integer> ret = new ArrayList<Integer>();
      for (int i = 0; i < visit.length; i++) {
        if (visit[i])
          ret.add(S[i]);
      }
      result.add(ret);
      return;
    }
    visit[idx] = true;
    subsetHelper2(idx + 1, S, result, visit);
    visit[idx] = false;
    subsetHelper2(idx + 1, S, result, visit);
  }

}
