package lc;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author leili
 * 
 */
public class LongestConsecutiveSequence {

  /**
   * O(nlgn) solution
   * 
   * @param num
   * @return
   */
  public int longestConsecutive(int[] num) {
    if (num == null || num.length == 0)
      return 0;
    Arrays.sort(num);

    int max = Integer.MIN_VALUE;
    int count = 1;
    int cur = num[0];
    for (int i = 1; i < num.length; i++) {
      if (num[i] - cur == 1) {
        count++;
      } else if (num[i] - cur == 0) {
        continue;
      } else {
        if (max < count)
          max = count;
        count = 1;
      }
      cur = num[i];
    }
    return Math.max(max, Math.max(1, count));
  }

  /**
   * O(n) runtime solution
   * find consecutive cluster and maintain the size of the cluster in a map
   * @param num
   * @return
   */
  public int longestConsecutive2(int[] num) {
    if (num == null || num.length == 0)
      return 0;
    int max = 1;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < num.length; i++) {
      if (map.containsKey(num[i]))
        continue;
      map.put(num[i], 1);
      if (map.containsKey(num[i] - 1))
        max = Math.max(max, merge(map, num[i] - 1, num[i]));
      if (map.containsKey(num[i] + 1))
        max = Math.max(max, merge(map, num[i], num[i] + 1));
    }
    return max;
  }

  private int merge(HashMap<Integer, Integer> map, int left, int right) {
    int upper = right + map.get(right) - 1;
    int lower = left - map.get(left) + 1;
    int len = upper - lower + 1;
    map.put(upper, len);
    map.put(lower, len);
    return len;
  }

}
