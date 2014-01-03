package basic.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeap {
  
  public static void main(String[] args){
    Comparator<Integer> comparator = new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2) {
        if (o1.intValue() < o2.intValue())
          return -1;
        else if (o1.intValue() > o2.intValue())
          return 1;
        else
          return 0;
      }
    };
    
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(5, comparator);
    heap.add(5);
    heap.add(4);
    heap.add(3);
    heap.add(2);
    heap.add(1);
    
    while (!heap.isEmpty()){
      System.out.println(heap.poll());
    }
  }

}
