package lc;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * @author leili
 *
 */
public class LongestValidParentheses {
  
  public int longestValidParentheses(String s){
    assert(s != null);
    
    int maxL = 0, lastR = -1;
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < s.length(); i++){
        if (s.charAt(i) == '(')
            stack.push(i);
        else {
            if (stack.empty()){
                lastR = i;
            } else {
                stack.pop();
                if (stack.empty())
                    maxL = Math.max(maxL, i-lastR);
                else
                    maxL = Math.max(maxL, i-stack.peek());
            }
        }
    }
    return maxL;
  }

}
