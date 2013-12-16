package basic.stackqueue;

/**
 * using an array to implement a queue
 * @author lli003
 *
 */
public class ArrayQueue {
  
  private int enqueueIdx;
  private int dequeueIdx;
  
  private int[] items;
  private int count;
  
  public ArrayQueue(int capacity){
    enqueueIdx = 0;
    dequeueIdx = 0;
    items = new int[capacity];
  }
  
  public void enqueue(int num){
    if (count == items.length){
      throw new UnsupportedOperationException();
    }
    items[enqueueIdx] = num;
    enqueueIdx = ++enqueueIdx == items.length ? 0 : enqueueIdx;
    count++;
  }
  
  public int dequeue(){
    if (count == 0){
      throw new UnsupportedOperationException();
    }
    int res = items[dequeueIdx];
    dequeueIdx = ++dequeueIdx == items.length ? 0 : dequeueIdx;
    count--;
    return res;
  }
  
  public static void main(String[] args){
    ArrayQueue queue = new ArrayQueue(5);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }

}
