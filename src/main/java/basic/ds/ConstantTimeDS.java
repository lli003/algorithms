package basic.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * a data structure that supports constant time add, delete, and get random
 * @author leili
 *
 */
public class ConstantTimeDS {
  
  /* basic idea: use a hashmap to store data, and use an arraylist to store the index. */
  private Map<Integer, Integer> data; // key is the data, value is the indx
  private List<Integer> index;
  private int size;
  private Random rnd;
  
  public ConstantTimeDS(){
    data = new HashMap<Integer, Integer>();
    index = new ArrayList<Integer>();
    size = 0;
    rnd = new Random();
  }
  
  public void add(int val){
    if (!data.containsKey(val)){
      data.put(val, size);
      if (size < index.size()){
        index.set(size, val);
      } else {
        index.add(val);
      }
      size++;
    }
  }
  
  public void delete(int val){
    if (!data.containsKey(val)){
      return;
    } else {
      int lastVal = index.get(index.size() - 1);
      int idx = data.get(val);
      data.put(lastVal, idx);
      index.set(idx, lastVal);
      data.remove(val);
      size--;
    }
  }
  
  public Integer getRandom(){
    if (size == 0)
      return -1;
    return index.get(rnd.nextInt(size));
  }

}
