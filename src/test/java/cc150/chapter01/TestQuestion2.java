package cc150.chapter01;

import org.junit.Test;

import cc150.chapter01.string.ReverseString;

public class TestQuestion2 {

  @Test
  public void testReverse() {
    ReverseString q2 = new ReverseString();
    System.out.println(q2.reverse("test"));
    System.out.println(q2.reverse("This is a test!"));
  }

}
