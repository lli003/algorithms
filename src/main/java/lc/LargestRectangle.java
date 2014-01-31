package lc;

import java.util.Arrays;
import java.util.Stack;

/**
 * given n non-negative integers representing the histogram's bar height 
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
For example,
Given height = [2,1,5,6,2,3],
return 10.
 * @author leili
 *
 */
public class LargestRectangle {
  
  /**
   * brute force: for a given height, check the left and right bound
   * @param height
   * @return
   */
  public int largestRectangleArea(int[] height){
    assert(height != null);
    
    int pre = -1;
    int max = 0;
    for (int i = 0; i < height.length; i++){
        if (height[i] == pre)
            continue;
        int j, k;
        for (j = i-1; j >= 0; j--){
            if (height[j] < height[i])
                break;
        }
        for (k = i+1; k < height.length; k++){
            if (height[k] < height[i])
                break;
        }
        max = Math.max(max, height[i] * (k-j-1));
    }
    return max;
  }
  
  /**
   * use stack to record the index with the largest height from left to right
   * @param height
   * @return
   */
  public int largestRectangleArea2(int[] height){
    assert(height != null);
    
    Stack<Integer> stack = new Stack<Integer>();
    height = Arrays.copyOf(height, height.length + 1);
    int i = 0, max = 0;
    while (i < height.length){
        if (stack.isEmpty() || height[stack.peek()] <= height[i]){
            stack.push(i++);
        } else {
            int t = stack.pop();
            max = Math.max(max, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }
    }
    return max;
  }

}
