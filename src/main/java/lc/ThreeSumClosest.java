package lc;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author leili
 *
 */
public class ThreeSumClosest {

  public int threeSumClosest(int[] num, int target) {

    if (num == null || num.length < 3)
      return 0;

    Arrays.sort(num);

    int sumDiff = Integer.MAX_VALUE;
    int sum = Integer.MAX_VALUE;
    for (int i = 0; i < num.length - 2; i++) {
      for (int j = num.length - 1; j >= i + 2; j--) {
        int tar = target - num[i] - num[j];
        int[] rev = getClosest(num, i + 1, j - 1, tar);
        if (Math.abs(tar - num[rev[0]]) < sumDiff) {
          sumDiff = Math.abs(tar - num[rev[0]]);
          sum = num[i] + num[j] + num[rev[0]];
        }
        if (Math.abs(tar - num[rev[1]]) < sumDiff) {
          sumDiff = Math.abs(tar - num[rev[1]]);
          sum = num[i] + num[j] + num[rev[1]];
        }
      }
    }
    return sum;
  }

  /**
   * find the two elements that are closest to the target
   * @param num
   * @param start
   * @param end
   * @param tar
   * @return
   */
  private int[] getClosest(int[] num, int start, int end, int tar) {
    int mid = 0;
    while (start < end) {
      mid = start + (end - start) / 2;
      if (num[mid] == tar)
        return new int[] { mid, mid };
      else if (tar < num[mid])
        end = mid - 1;
      else if (tar < num[mid + 1]) {
        return new int[] { mid, mid + 1 };
      } else
        start = mid + 1;
    }
    return new int[] { start, start };
  }
  
  /**
   * O(n^2)
   * @param num
   * @param target
   * @return
   */
  public int threeSumClosest2(int[] num, int target) {
    assert(num != null);
    
    if (num.length < 3)
        return 0;
        
    Arrays.sort(num);
    
    int close = target;
    int diff = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 0; i < num.length - 2; i++){
        for (int j = i+1, k = num.length - 1; j < k;){
            sum = num[i] + num[j] + num[k];
            if (sum == target)
                return sum;
            else {
              if (Math.abs(sum - target) < diff){
                close = sum;
                diff = Math.abs(sum - target);
              }
              if (sum < target)
                j++;
              else
                k--;
            }
        }
    }
    
    return close;
}

}
