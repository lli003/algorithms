package cc150.chapter01;

import org.junit.Test;

public class TestQuestion3 {

  @Test
  public void testRemoveDuplicates() {
    RemoveDuplicatesInString q3 = new RemoveDuplicatesInString();
    System.out.println(q3.removeDuplicates("abcd"));
    System.out.println(q3.removeDuplicates("aaad"));
    System.out.println(q3.removeDuplicates("aaaa"));
    System.out.println(q3.removeDuplicates("aaabbb"));
    System.out.println(q3.removeDuplicates("ababa"));
  }

}
