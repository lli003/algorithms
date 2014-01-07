package cc150.chapter01;

import org.junit.Test;

public class TestQuestion4 {

  @Test
  public void test() {
    Anagram q4 = new Anagram();
    System.out.println(q4.isAnagram("aa", "b"));
    System.out.println(q4.isAnagram("aa", "bb"));
    System.out.println(q4.isAnagram("ab", "ba"));
  }

}
