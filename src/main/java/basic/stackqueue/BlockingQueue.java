package basic.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A blocking queue is a queue that blocks when you try to dequeue from it and the queue is empty, 
 * or if you try to enqueue items to it and the queue is already full. 
 * A thread trying to dequeue from an empty queue is blocked until some other thread inserts 
 * an item into the queue. A thread trying to enqueue an item in a full queue is blocked 
 * until some other thread makes space in the queue, either by dequeuing one or more items 
 * or clearing the queue completely.
 * @author lli003
 *
 * @param <T>
 */
public class BlockingQueue<T> {
  
  private Queue<T> queue = new LinkedList<T>();
  private int capacity = 10;
  
  public BlockingQueue(int capacity){
    this.capacity = capacity;
  }
  
  public synchronized void enqueue(T t) throws InterruptedException{
    while (queue.size() == this.capacity){
      wait();
    }
    if (queue.size() == 0){
      notifyAll();
    }
    queue.add(t);
  }
  
  public synchronized T dequeue() throws InterruptedException{
    while (queue.size() == 0){
      wait();
    }
    if (queue.size() == this.capacity){
      notifyAll();
    }
    return queue.remove();
  }
  
  public static void main(String[] args){
    BlockingQueue<Integer> queue = new BlockingQueue<Integer>(10);
    Worker[] workers = new Worker[2];
    for (int i = 0; i < workers.length; i++){
      workers[i] = new Worker(queue);
      workers[i].start();
    }
    
    for (int i = 0; i < 100; i++){
      try {
        queue.enqueue(i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}

class Worker extends Thread {
  
  BlockingQueue<Integer> queue;
  Worker(BlockingQueue<Integer> queue){
    this.queue = queue;
  }
  
  public void run(){
    try{
      while(true){
        Integer i = queue.dequeue();
        if (i == null)
          break;
        System.out.println(i);
      }
    } catch (InterruptedException e){
      e.printStackTrace();
    }
  }
}
