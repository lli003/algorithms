package cc150.chapter01;

import org.junit.Test;

public class TestQuestion4 {

  @Test
  public void test() {
    Question4 q4 = new Question4();
    System.out.println(q4.isAnagram("aa", "b"));
    System.out.println(q4.isAnagram("aa", "bb"));
    System.out.println(q4.isAnagram("ab", "ba"));
  }

}
