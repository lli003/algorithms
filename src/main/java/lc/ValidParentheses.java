package lc;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author leili
 *
 */
public class ValidParentheses {

  public boolean isValid(String s) {
    if (s.length() == 0)
      return true;

    int l = s.length();
    int i = 0;
    Stack<Character> stack = new Stack<Character>();
    while (i < l) {
      if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(')
        stack.push(s.charAt(i));
      else if (s.charAt(i) == ']') {
        if (!stack.isEmpty() && stack.peek() == '[')
          stack.pop();
        else
          return false;
      } else if (s.charAt(i) == '}') {
        if (!stack.isEmpty() && stack.peek() == '{')
          stack.pop();
        else
          return false;
      } else if (s.charAt(i) == ')') {
        if (!stack.isEmpty() && stack.peek() == '(')
          stack.pop();
        else
          return false;
      }
      i++;
    }
    return stack.isEmpty();
  }

}
