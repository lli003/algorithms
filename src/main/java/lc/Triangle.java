package lc;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @author leili
 *
 */
public class Triangle {

  /**
   * in-place
   * @param triangle
   * @return
   */
  public int minimalTotal(ArrayList<ArrayList<Integer>> triangle) {
    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        triangle.get(i).set(
            j,
            triangle.get(i).get(j)
                + Math.min(triangle.get(i + 1).get(j),
                    triangle.get(i + 1).get(j + 1)));
      }
    }
    return triangle.get(0).get(0);
  }

}
