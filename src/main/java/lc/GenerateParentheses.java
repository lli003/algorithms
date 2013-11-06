package lc;

import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author leili
 *
 */
public class GenerateParentheses {
  
  /**
   * recursive solution
   * add a (, then add a )
   * @param n
   * @return
   */
  public ArrayList<String> generateParenthesis(int n){
    if (n == 0)
      return new ArrayList<String>();
    
    return generate(n, 0, 0, new StringBuffer(""));
  }
  
  private ArrayList<String> generate(int n, int l, int r, StringBuffer sb){
    ArrayList<String> result = new ArrayList<String>();
    
    if (l > n || r > n)
      return result;
    
    if (r == n){
      result.add(sb.toString());
      return result;
    }
    
    if (l < n){
      StringBuffer newSb = new StringBuffer(sb);
      newSb.append("(");
      result.addAll(generate(n, l+1, r, newSb));
    }
    
    if (r < l){
      StringBuffer newSb = new StringBuffer(sb);
      newSb.append(")");
      result.addAll(generate(n, l, r+1, newSb));
    }
    
    return result;
  }

}
