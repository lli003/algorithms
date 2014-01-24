package basic.math;

import java.util.ArrayList;
import java.util.List;

public class OperatorTarget {

  private String[] ops = { "+", "-", "*", "/" };

  private int compute(String op, int x, int y) {
    if (op.equals("+"))
      return x + y;
    else if (op.equals("-"))
      return x - y;
    else if (op.equals("*"))
      return x * y;
    else
      return x / y;
  }

  public boolean postFix(List<Integer> nums, int target) {
    assert (nums != null);
    int cur = 0, step = 0;
    return helper(nums, target, cur, step);
  }

  private boolean helper(List<Integer> nums, int target, int cur, int step) {
    if (target == cur)
      return true;
    if (step == nums.size() && target != cur)
      return false;
    for (String op : ops) {
      int x = nums.get(step);
      if (helper(nums, target, compute(op, cur, x), step+1)) {
        return true;
      }
    }
    return false;
  }
  
  public static void main(String[] args){
    List<Integer> nums = new ArrayList<Integer>();
    nums.add(6);
    nums.add(5);
    nums.add(4);
    nums.add(3);
    nums.add(2);
    nums.add(1);
    
    OperatorTarget ot = new OperatorTarget();
    System.out.println(ot.postFix(nums, -5));
  }

}
