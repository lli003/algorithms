package lc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSingleNumber {

  @Test
  public void testSingleNumber() {
    SingleNumber sn = new SingleNumber();
    
    int truth = 1;
    int[] A = {3,3,2,1,2,4,4};
    assertTrue(sn.singleNumber(A) == truth);
  }

}
