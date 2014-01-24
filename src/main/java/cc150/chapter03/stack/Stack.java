package cc150.chapter03.stack;

public class Stack {
  
  private int capacity;
  public Node top, bottom;
  public int size = 0;
  
  public Stack(int capacity){
    this.capacity = capacity;
  }
  
  public boolean isFull(){
    return this.capacity == size;
  }
  
  public boolean isEmpty(){
    return size == 0;
  }
  
  public void join(Node above, Node below){
    if (below != null)
      below.above = above;
    if (above != null)
      above.below = below;
  }
  
  public void push(int value){
    if (isFull()){
      throw new UnsupportedOperationException();
    }
    size++;
    Node n = new Node(value);
    if (size == 1)
      bottom = n;
    join(n, top);
  }
  
  public int pop(){
    Node t = top;
    top = top.below;
    size--;
    return t.val;
  }
  
  public int removeBottom(){
    Node b = bottom;
    bottom = bottom.above;
    if (bottom != null)
      bottom.below = null;
    size--;
    return b.val;
  }

}
