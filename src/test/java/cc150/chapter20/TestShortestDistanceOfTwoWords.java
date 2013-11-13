package cc150.chapter20;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestShortestDistanceOfTwoWords {

  @Test
  public void testSearchWords() {
    ShortestDistanceOfTwoWords sh = new ShortestDistanceOfTwoWords();
    String[] words = {"a", "b", "e", "c", "a", "a", "b", "c"};
    String word1 = "a";
    String word2 = "c";
    assertTrue(sh.searchWords(words, word1, word2) == 1);
  }

}
