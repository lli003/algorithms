package lc;

public class JumpGameII {

  /**
   * Start from slot i, we use max to track the farthest slot we can reach
   * within one jump from i and use next to track the next position where we
   * need to jump.
   * 
   * @param A
   * @return
   */
  public int jump(int[] A) {
    int steps = 0;
    for (int i = 1, max = A[0], next = 0; i < A.length; ++i) {
      if (i > next) {
        if (max < i)
          return -1; // unreachable
        next = max;
        ++steps;
      }
      max = Math.max(max, i + A[i]);
    }
    return steps;
  }

}
