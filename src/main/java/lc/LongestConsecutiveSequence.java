package lc;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 * @author leili
 *
 */
public class LongestConsecutiveSequence {

  /**
   * O(nlgn) solution
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

}
