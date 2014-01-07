package lc;

import java.util.ArrayList;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * @author leili
 * 
 */
public class Permutations {

  /**
   * depth-first search
   * 
   * @param num
   * @return
   */
  public ArrayList<ArrayList<Integer>> permute(int[] num) {
    if (num.length == 0)
      return new ArrayList<ArrayList<Integer>>();
    return dfs(num, 0, num.length - 1);
  }

  private ArrayList<ArrayList<Integer>> dfs(int[] num, int start, int end) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (start >= end) {
      ArrayList<Integer> list = new ArrayList<Integer>();
      for (int i = 0; i < num.length; i++)
        list.add(num[i]);
      result.add(list);
    } else {
      for (int i = start; i <= end; i++) {
        swap(num, start, i);
        result.addAll(dfs(num, start + 1, end));
        swap(num, start, i);
      }
    }
    return result;
  }

  private void swap(int[] num, int idx1, int idx2) {
    int temp = num[idx1];
    num[idx1] = num[idx2];
    num[idx2] = temp;
  }

  public ArrayList<ArrayList<Integer>> permute2(int[] num) {
    if (num == null)
      return null;

    /*
     * use a boolean vector to record whether the i-th index has been visited or not.
     */
    return helper(num, 0, new boolean[num.length]);
  }

  private ArrayList<ArrayList<Integer>> helper(int[] num, int start,
      boolean[] used) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (start == num.length)
      result.add(new ArrayList<Integer>());
    else {
      for (int i = 0; i < num.length; i++) {
        if (used[i])
          continue;
        used[i] = true;
        for (ArrayList<Integer> res : helper(num, start + 1, used)) {
          res.add(num[i]);
          result.add(res);
        }
        used[i] = false;
      }
    }
    return result;
  }

}
