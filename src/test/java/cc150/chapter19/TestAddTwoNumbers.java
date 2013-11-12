package cc150.chapter19;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAddTwoNumbers {

  @Test
  public void testAddTwoNumbers() {
    AddTwoNumbers addTN = new AddTwoNumbers();
    
    int a = 100, b = 235;
    int truth = 335;
    assertTrue(truth == addTN.addTwoNumbers(a, b));
  }

}
