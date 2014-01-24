package cc150.chapter01;

import org.junit.Test;

import cc150.chapter01.string.ReplaceWithSpace;

public class TestQuestion5 {

  @Test
  public void testReplaceSpace() {
    ReplaceWithSpace q5 = new ReplaceWithSpace();
    System.out.println(q5.replaceSpace("abc"));
    System.out.println(q5.replaceSpace(" abc"));
    System.out.println(q5.replaceSpace("abc "));
    System.out.println(q5.replaceSpace(" a b c "));
    System.out.println(q5.replaceSpace("   "));
  }

}
