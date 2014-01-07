package cc150.chapter03;

import java.util.ArrayList;

/**
 * SetOfStacks should be composed of several stacks, 
 * and should create a new stack once the previous one exceeds capacity. 
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack 
 * (that is, pop() should return the same values as it would if there were just a single stack).
 * 
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 * @author lli003
 *
 */
public class SetOfStacks {
  
  ArrayList<Stack> stacks = new ArrayList<Stack>();
  
  public int capacity;
  public SetOfStacks(int capacity){
    this.capacity = capacity;
  }
  
  public Stack getLastStack(){
    if (stacks.size() > 0)
      return stacks.get(stacks.size() - 1);
    return null;
  }
  
  public void push(int value){
    Stack last = getLastStack();
    if (last != null && !last.isFull()){
      last.push(value);
    } else {
      Stack stack = new Stack(capacity);
      stack.push(value);
      stacks.add(stack);
    }
  }
  
  public int pop(){
    Stack last = getLastStack();
    int value = last.pop();
    if (last.isEmpty())
      stacks.remove(stacks.size() - 1);
    return value;
  }
  
  public int popAt(int index){
    return leftShift(index, true);
  }
  
  public int leftShift(int index, boolean removeTop){
    Stack stack = stacks.get(index);
    int removed = 0;
    if (removeTop)
      removed = stack.pop();
    else
      removed = stack.removeBottom();
    if (stack.isEmpty())
      stacks.remove(index);
    else if (stacks.size() > index + 1){
      int v = leftShift(index + 1, false);
      stack.push(v);
    }
    return removed;
  }

}
