package basic.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval{
  int s, e;
  public Interval(int start, int end){
    s = start;
    e = end;
  }
  
  public String toString(){
    return "<" + s + "," + e + ">"; 
  }
}

public class IntervalScheduling {
  
  Comparator<Interval> comparator = new Comparator<Interval>(){
    public int compare(Interval i1, Interval i2){
      return i1.e - i2.e;
    }
  };
  
  /* basic idea: sort interval by end time, and then greedily select intervals with the earliest end time. */
  public ArrayList<Interval> intervalScheduling(ArrayList<Interval> input){
    assert(input != null);
    
    ArrayList<Interval> result = new ArrayList<Interval>();
    if (input.size() == 0)
      return result;
    if (input.size() == 1)
      return input;
    
    Collections.sort(input, comparator);
    while (input.size() > 0){
      Interval a = input.get(0);
      input.remove(0);
      result.add(a);
      for (int i = input.size() - 1; i >= 0; i--){
        if (!isNoOverlap(a, input.get(i)))
          input.remove(i);
      }
    }
    return result;
  }
  
  private boolean isNoOverlap(Interval i1, Interval i2){
    return Math.max(i1.s, i2.s) >= Math.min(i1.e, i2.e);
  }
  
  public static void main(String[] args){
    ArrayList<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(0,3));
    input.add(new Interval(2,4));
    input.add(new Interval(5,6));
    input.add(new Interval(7,10));
    input.add(new Interval(11,21));
    input.add(new Interval(13,16));
    input.add(new Interval(16,19));
    input.add(new Interval(23,24));
    input.add(new Interval(23,25));
    
    IntervalScheduling is = new IntervalScheduling();
    ArrayList<Interval> result = is.intervalScheduling(input);
    for (Interval i : result)
      System.out.println(i.toString());
  }

}
