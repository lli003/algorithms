package lc;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class TestThreeSum {

  @Test
  public void testThreeSum() {
    ThreeSum ts = new ThreeSum();
    
    int[] num = {-1,0,1,2,-1,-4};
    ArrayList<ArrayList<Integer>> truth = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> sol1 = new ArrayList<Integer>(){{add(-1); add(0); add(1);}};
    ArrayList<Integer> sol2 = new ArrayList<Integer>(){{add(-1); add(-1); add(2);}};
    truth.add(sol1);
    truth.add(sol2);
    
    assertTrue(truth.equals(ts.threeSum(num)));
  }

}
