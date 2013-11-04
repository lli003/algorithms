package lc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReverseInteger {

  @Test
  public void testReverse() {
    ReverseInteger ri = new ReverseInteger();
    
    // test case
    int t1 = 321;
    assertTrue(t1 == ri.reverse(123));
    
    int t2 = 1;
    assertTrue(t2 == ri.reverse(100));
  }

}
