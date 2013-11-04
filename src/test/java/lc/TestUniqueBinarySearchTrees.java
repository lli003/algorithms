package lc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUniqueBinarySearchTrees {

  @Test
  public void testNumTrees() {
    UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();
    
    int n = 3;
    int result = 5;
    assertTrue(result == ubst.numTrees(n));
  }

}
