package cc150.chapter01;

import org.junit.Test;

public class TestQuestion3 {

  @Test
  public void testRemoveDuplicates() {
    Question3 q3 = new Question3();
    System.out.println(q3.removeDuplicates("abcd"));
    System.out.println(q3.removeDuplicates("aaad"));
    System.out.println(q3.removeDuplicates("aaaa"));
    System.out.println(q3.removeDuplicates("aaabbb"));
  }

}
