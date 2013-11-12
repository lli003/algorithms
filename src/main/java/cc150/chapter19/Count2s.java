package cc150.chapter19;

/**
 * Write a method to count the number of 2s between 0 and n.
 * @author lli003
 *
 */
public class Count2s {
  
  public int count2s(int a){
    // termination condition
    if (a == 0)
      return 0;
    
    // get the power
    int power = 1;
    while (10 * power < a)
      power *= 10;
    
    int first = a / power;
    int remainder = a % power;
    
    // count how many 2s 
    int twoAtFirst = 0;
    if (first > 2)
      twoAtFirst += power;
    else if (first == 2)
      twoAtFirst += remainder + 1;
    
    int twoAtOther = first * count2s(power - 1) + count2s(remainder);
    
    return twoAtFirst + twoAtOther;
  }

}
