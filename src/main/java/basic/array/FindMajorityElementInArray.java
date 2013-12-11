package basic.array;

/**
 * find the majority element in an array
 * @author leili
 *
 */
public class FindMajorityElementInArray {
  
  /**
   * make an initial guess of the majority
   * if meeting the same integer, count++;
   * else count--;
   * if count == 0, reset the majority as the current integer 
   * @param num
   * @return
   */
  public static int findMajority(int[] num){
    int count = 0,  majority = 0;
    for (int i = 0; i < num.length; i++){
      if (count == 0)
        majority = num[i];
      if (num[i] == majority)
        count++;
      else
        count--;
    }
    count = 0;
    for (int i = 0; i < num.length; i++){
      if (num[i] == majority)
        count++;
    }
    if (count >= num.length / 2)
      return majority;
    return -1;
  }
  
  public static void main(String[] args){
    int[] num = {5,2,3,3,3,2,1,3,3};
    System.out.println(FindMajorityElementInArray.findMajority(num));
  }

}
