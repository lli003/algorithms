package basic.array;

import java.util.HashSet;

/**
 * you have an array of numbers from 0 to N-1, one of the numbers is removed, 
 * and replaced with a number already in the array which makes a duplicate of that number. 
 * How can we detect this duplicate in time O(N).
 */
public class DuplicateInN {
  
  /**
   * O(n^2) time
   * @param num
   * @return
   */
  public static int findDuplicate(int[] num){
    for (int i = 0; i < num.length; i++){
      for (int k = 0; k < i; k++){
        if (num[i] == num[k])
          return num[i];
      }
    }
    return -1;
  }
  
  /**
   * O(n) space
   * @param num
   * @return
   */
  public static int findDuplicate2(int[] num){
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < num.length; i++){
      if (set.contains(num[i]))
        return num[i];
      set.add(num[i]);
    }
    return -1;
  }
  
  /**
   * O(n) time, modifying array
   * @param num
   * @return
   */
  public static int findDuplicate3(int[] num){
    for (int i = 0; i < num.length; i++){
      if (num[num[i]] < 0)
        return num[i];
      num[num[i]] = 0 - num[num[i]];
    }
    return -1;
  }
  
  /**
   * O(n) time, without modifying array
   * @param num
   * @return
   */
  public static int findDuplicate4(int[] num){
    int sum = 0;
    int sumSquare = 0;
    for (int i = 0; i < num.length; i++){
      sum += num[i];
      sumSquare += num[i] * num[i];
    }
    int l = num.length;
    int trueSum = (l * (l-1))/2;
    int trueSumSquare = (l * (l-1) * (2*l-1)) / 6;
    int a = trueSum - sum;
    int b = (trueSumSquare - sumSquare)/a;
    return (b-a)/2;
  }
  
  public static void main(String[] args){
    int[] num = {0,1,2,2,3,5};
//    System.out.println(DuplicateInN.findDuplicate(num));
//    System.out.println(DuplicateInN.findDuplicate2(num));
//    System.out.println(DuplicateInN.findDuplicate3(num));
    System.out.println(DuplicateInN.findDuplicate4(num));
  }

}
