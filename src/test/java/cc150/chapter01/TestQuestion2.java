package cc150.chapter01;

import org.junit.Test;

public class TestQuestion2 {

  @Test
  public void testReverse() {
    ReverseString q2 = new ReverseString();
    System.out.println(q2.reverse("test"));
    System.out.println(q2.reverse("This is a test!"));
  }

}
