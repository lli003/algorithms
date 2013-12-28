package cc150.chapter01;

import org.junit.Test;

public class TestQuestion2 {

  @Test
  public void testReverse() {
    Question2 q2 = new Question2();
    System.out.println(q2.reverse("test"));
    System.out.println(q2.reverse("This is a test!"));
  }

}
