package cc150.chapter03.stack;

import java.util.Stack;

public class SortStack {
  
  public Stack<Integer> sort(Stack<Integer> s){
    Stack<Integer> copy = new Stack<Integer>();
    while (!s.isEmpty()){
      int tmp = s.pop();
      while (!copy.isEmpty() && copy.peek() > tmp){
        s.push(copy.pop());
      }
      copy.push(tmp);
    }
    return copy;
  }
  
  public static void main(String[] args){
    SortStack ss = new SortStack();
    Stack<Integer> s = new Stack<Integer>();
    s.push(1);
    s.push(2);
    s.push(5);
    s.push(3);
    s.push(9);
    s.push(10);
    s.push(4);
    s.push(6);
    s.push(7);
    s.push(8);
    
    s = ss.sort(s);
    while (!s.isEmpty()){
      System.out.println(s.pop());
    }
  }

}
