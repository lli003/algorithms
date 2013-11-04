package lc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTwoSum {

  @Test
  public void test() {
    TwoSum twoSum = new TwoSum();
    int[] numbers = {4,2,3,3,5,6};
    int target = 10;
    int[] result = twoSum.twoSum(numbers, target);
    int[] truth = {1,6};
    for (int i = 0; i < result.length; i++){
      assertTrue(result[i] == truth[i]);
    }
  }

}
