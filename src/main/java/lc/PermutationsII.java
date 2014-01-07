package lc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 * @author lli003
 *
 */
public class PermutationsII {

  public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    if (num == null)
      return null;
    Arrays.sort(num);

    /*
     * use a boolean vector to record whether the i-th index has been visited or
     * not.
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
        if (used[i] || i > 0 && !used[i - 1] && num[i - 1] == num[i])
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
