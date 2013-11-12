package cc150.chapter19;

/**
 * Write a function to swap a number in place without temporary variables.
 * @author lli003
 *
 */
public class SwapTwoNumbers {
  
  public void swap(int a, int b){
    a = b - a;
    b = b - a; // now b equals to a
    a = a + b; // now a equals to b
    
    System.out.println("a : " + a);
    System.out.println("b : " + b);
  }
  
  public void swap2(int a, int b){
    a = a ^ b;
    b = a ^ b; // now b equals to a
    a = a ^ b; // now a equals to b
    
    System.out.println("a : " + a);
    System.out.println("b : " + b);
  }

}
