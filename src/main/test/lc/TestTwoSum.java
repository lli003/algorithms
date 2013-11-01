package lc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTwoSum {

  @Test
  public void testTwoSum() {
    TwoSum twoSum = new TwoSum();
    
    int target = 10;
    int[] numbers = {1,2,3,4,5,6};
    
    int[] result = twoSum.twoSum(numbers, target);
    int[] truth = {4,6};
    for (int i = 0; i < result.length; i++){
      assertTrue(result[i] == truth[i]);
    }
  }

}
