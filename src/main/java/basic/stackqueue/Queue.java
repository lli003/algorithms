package basic.stackqueue;

import java.util.Stack;

public class Queue<T> {
  
  Stack<T> inStack = new Stack<T>();
  Stack<T> outStack = new Stack<T>();
  
  public void enQueue(T t){
    inStack.push(t);
  }
  
  public T deQueue(){
    if (outStack.empty()){
      while (!inStack.empty()){
        outStack.push(inStack.pop());
      }
    }
    if (outStack.empty()){
      throw new UnsupportedOperationException("Queue is empty!");
    }
    return outStack.pop();
  }
  
  public int size(){
    if (!inStack.empty()){
      return inStack.size();
    } else {
      return outStack.size();
    }
  }
  
  public static void main(String[] args){
    Queue<Integer> queue = new Queue<Integer>();
    queue.enQueue(1);
    queue.enQueue(2);
    System.out.println(queue.size());
    System.out.println(queue.deQueue());
    System.out.println(queue.size());
  }

}
