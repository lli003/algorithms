package basic.stackqueue;

import java.util.Stack;

/**
 * a stack that supports push, pop and get the minimum value in O(1) time
 * @author lli003
 *
 */
public class MinStack {
  
  private Stack<Integer> stack = new Stack<Integer>();
  
  private Integer currentMin;
  
  public Integer getMin(){
    return currentMin;
  }
  
  public void push(Integer i){
    if (stack.empty() || i <= currentMin){
      stack.push(currentMin);
      stack.push(i);
      currentMin = i;
    } else {
      stack.push(i);
    }
  }
  
  public Integer pop(){
    Integer i = stack.pop();
    if (i == currentMin){
      currentMin = stack.pop();
    }
    return i;
  }
  
  public static void main(String[] args){
    MinStack stack = new MinStack();
    stack.push(2);
    System.out.println(stack.getMin());
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println(stack.getMin());
    stack.push(1);
    System.out.println(stack.getMin());
    
    
    stack.pop();
    System.out.println(stack.getMin());
    stack.pop();
    System.out.println(stack.getMin());
  }

}
