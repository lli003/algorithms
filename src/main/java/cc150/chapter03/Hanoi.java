package cc150.chapter03;

import java.util.Stack;

class Tower{
  private Stack<Integer> stack;
  private int index;
  
  public Tower(int i){
    this.stack = new Stack<Integer>();
    this.index = i;
  }
  
  public int index(){
    return this.index;
  }
  
  public void add(int val){
    if (!stack.isEmpty() && stack.peek() <= val){
      throw new UnsupportedOperationException();
    } else {
      stack.push(val);
    }
  }
  
  public void moveTopTo(Tower t){
    t.stack.push(stack.pop());
  }
  
  public void print(){
    System.out.print("Tower " + this.index + ":\n\t");
    for (int i = stack.size() - 1; i >= 0; i--){
      System.out.print(stack.get(i) + " ");
    }
    System.out.println();
  }
  
  public void moveDisks(int n, Tower dest, Tower buff){
    if (n > 0){
      moveDisks(n-1, buff, dest);
      moveTopTo(dest);
      buff.moveDisks(n-1, dest, this);
    }
  }
}

public class Hanoi {
  
  public static void main(String[] args){
    int n = 5;
    Tower[] towers = new Tower[3];
    for (int i = 0; i < towers.length; i++){
      towers[i] = new Tower(i);
    }
    for (int i = n - 1; i >= 0; i--){
      towers[0].add(i);
    }
    System.out.println("Before moving:");
    towers[0].print();
    towers[1].print();
    towers[2].print();
    
    towers[0].moveDisks(n, towers[2], towers[1]);
    
    System.out.println("After moving:");
    towers[0].print();
    towers[1].print();
    towers[2].print();
  }
}
