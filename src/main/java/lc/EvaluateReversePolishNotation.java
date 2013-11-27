package lc;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author lli003
 *
 */
public class EvaluateReversePolishNotation {

  public int evalRPN(String[] tokens) {
    assert (tokens != null);

    if (tokens.length == 0)
      return 0;

    Stack<Integer> nums = new Stack<Integer>();
    for (int i = 0; i < tokens.length; i++) {
      if (isInteger(tokens[i]))
        nums.push(Integer.parseInt(tokens[i]));
      else {
        if (tokens[i].equals("+"))
          nums.push(nums.pop() + nums.pop());
        else if (tokens[i].equals("*"))
          nums.push(nums.pop() * nums.pop());
        else if (tokens[i].equals("-")) {
          Integer i1 = nums.pop();
          Integer i2 = nums.pop();
          nums.push(i2 - i1);
        } else if (tokens[i].equals("/")) {
          Integer i1 = nums.pop();
          Integer i2 = nums.pop();
          nums.push(i2 / i1);
        }
      }
    }
    return nums.pop();
  }

  private boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}
