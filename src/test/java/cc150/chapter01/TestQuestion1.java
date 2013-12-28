package cc150.chapter01;

import org.junit.Test;

public class TestQuestion1 {

  @Test
  public void testIsUnique() {
    Question1 q1 = new Question1();
    
    System.out.println(q1.isUnique("123abc123"));
    System.out.println(q1.isUnique("abca"));
    System.out.println(q1.isUnique("abc"));
    System.out.println();
    
    System.out.println(q1.isUnique2("123abc123"));
    System.out.println(q1.isUnique2("abca"));
    System.out.println(q1.isUnique2("abc"));
    System.out.println();
    
    System.out.println(q1.isUnique3("123abc123"));
    System.out.println(q1.isUnique3("abca"));
    System.out.println(q1.isUnique3("abc"));
  }

}
