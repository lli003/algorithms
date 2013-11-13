package cc150.chapter20;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWordBreak {

  @Test
  public void test() {
    WordBreak wb = new WordBreak();
    String[] words = {"helloworld", "hello", "world", "helloworldworld", "a", "b", "c"};
    assertTrue("helloworldworld".equals(wb.getLongestWord(words)));
  }

}
