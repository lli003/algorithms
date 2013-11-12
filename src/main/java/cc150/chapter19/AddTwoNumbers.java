package cc150.chapter19;

/**
 * add two numbers without using + and other arithmetic operations
 * 
 * @author lli003
 * 
 */
public class AddTwoNumbers {

  // basic idea:
  // calculate the sum without considering carry
  // calculate carry
  // using bit operation
  public int addTwoNumbers(int a, int b) {
    // termination condition
    if (b == 0)
      return a;
    int sum = a ^ b; // sum without carry
    int carry = (a & b) << 1; // carry
    return addTwoNumbers(sum, carry); // recursive
  }

}
