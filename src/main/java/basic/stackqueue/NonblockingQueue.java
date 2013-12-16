package basic.stackqueue;

import java.util.concurrent.atomic.AtomicReference;

public class NonblockingQueue<T> {
  
  private static class Node<T>{
    final T item;
    final AtomicReference<Node<T>> next;
    public Node(T item, Node<T> next){
      this.item = item;
      this.next = new AtomicReference<Node<T>>(next);
    }
  }
  
  private final Node<T> dummy = new Node<T>(null, null);
  private final AtomicReference<Node<T>> head = new AtomicReference<Node<T>>(dummy);
  private final AtomicReference<Node<T>> tail = new AtomicReference<Node<T>>(dummy);
  
  public boolean put(T item){
    Node<T> newNode = new Node<T>(item, null);
    while (true){
      Node<T> curTail = tail.get();
      Node<T> tailNext = curTail.next.get();
      if (curTail == tail.get()) { // did tail change?
        if (tailNext != null){ // Queue in itermediate state, advance tail
          tail.compareAndSet(curTail, tailNext);
        } else { // Queue in quiescent state, try inserting new node
          if (curTail.next.compareAndSet(null, newNode)){
            // insertion succeeded, try advancing tail
            tail.compareAndSet(curTail, newNode); // will fail if tail already moved
            return true;
          }
        }
      }
    }
  }
  
  public T take(){
    while (true){ // keep trying until take is done
      Node<T> oldHead = head.get(); // get current head
      Node<T> oldTail = tail.get(); // get current tail
      Node<T> oldHeadNext = oldHead.next.get(); // get current head next
      if (oldHead == head.get()){ // are head, tail and next consistent?
        if (oldHead == oldTail){ // Queue empty or tail being updated?
          if (oldHeadNext == null)
            return null; // Queue is empty
          tail.compareAndSet(oldTail, oldHeadNext); // tail updated, try to advance it
        }
      } else { // no need to deal with tail
        if (head.compareAndSet(oldHead, oldHeadNext))
          return oldHeadNext.item;
      }
    }
  }

}
