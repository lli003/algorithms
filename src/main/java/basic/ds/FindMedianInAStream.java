package basic.ds;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * find the median in a stream of integers
 * basic idea: maintain two heaps, 
 * minheap to store integers larger than median, maxheap to store integers less than median
 * balance the sizes of two heaps such that their number of elements differs upmost 1
 * @author leili
 *
 */
public class FindMedianInAStream {
  
  private Queue<Integer> minHeap;
  private Queue<Integer> maxHeap;
  private int numOfElements;
  
  public FindMedianInAStream(){
    minHeap = new PriorityQueue<Integer>();
    maxHeap = new PriorityQueue<Integer>(10, new MaxHeapComparactor());
    numOfElements = 0;
  }
  
  public void insert(int x){
    maxHeap.offer(x);
    if (numOfElements % 2 == 0){
      if (minHeap.isEmpty()){
        numOfElements++;
        return;
      } else if (minHeap.peek() < maxHeap.peek()){
        int minRoot = minHeap.poll();
        int maxRoot = maxHeap.poll();
        minHeap.offer(maxRoot);
        maxHeap.offer(minRoot);
      }
    } else {
      minHeap.offer(maxHeap.poll());
    }
    numOfElements++;
  }
  
  private class MaxHeapComparactor implements Comparator<Integer>{
    public int compare(Integer i1, Integer i2){
      return i2 - i1;
    }
  }
  
  public int getMedian(){
    if (numOfElements % 2 == 0){
      return (minHeap.peek() + maxHeap.peek()) / 2;
    } else {
      return maxHeap.peek();
    }
  }
  
  public static void main(String[] args){
    int[] num = {0,1,2,3,4,5,6,7,8,9,10,9,8,7,6,5,4,3,2,1,0};
    FindMedianInAStream stream = new FindMedianInAStream();
    for (int i = 0; i < num.length; i++){
      stream.insert(num[i]);
      System.out.println(stream.getMedian());
    }
  }

}
