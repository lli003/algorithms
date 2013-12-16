package basic.collections;

import java.util.ArrayList;

public class NestedIntegerSum {
  
  public int sumOfNestedIntegerCollection(ArrayList<Object> list, int level){
    int sum = 0;
    for (Object o : list){
      if (o instanceof Integer){
        sum += ((Integer) o) * level;
      } else {
        sum += sumOfNestedIntegerCollection((ArrayList) o, level + 1);
      }
    }
    return sum;
  }
  
  public static void main(String[] args){
    NestedIntegerSum ni = new NestedIntegerSum();
    ArrayList<Object> list = new ArrayList<Object>();
    list.add(1);
    ArrayList<Integer> i1 = new ArrayList<Integer>();
    i1.add(2);
    i1.add(3);
    list.add(i1);
    
    list.add(4);
    ArrayList<Integer> i2 = new ArrayList<Integer>();
    i2.add(5);
    i2.add(6);
    list.add(i2);
    
    System.out.println(ni.sumOfNestedIntegerCollection(list, 1));
  }

}
