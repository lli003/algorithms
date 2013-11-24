package basic.ds;

import java.util.Iterator;

import junit.framework.TestCase;

import org.junit.Test;

public class TestTrie extends TestCase{
  
  Trie<Integer> trie;
  
  @Override
  public void setUp(){
    trie = new Trie<Integer>();
    trie.put("she", 0);
    trie.put("sells", 1);
    trie.put("sea", 2);
    trie.put("shells", 3);
    trie.put("by", 4);
    trie.put("the", 5);
    trie.put("sea", 6);
    trie.put("shore", 7);
  }

  @Test
  public void testSize() {
    assertTrue(trie.size() == 8);
  }

  @Test
  public void testGet() {
    assertTrue(trie.get("she") == 0);
  }

  @Test
  public void testPut() {
    trie.put("shee", 8);
    assertTrue(trie.get("shee") == 8);
  }

  @Test
  public void testKeys() {
    Iterator<String> iterator = trie.keys().iterator();
    System.out.println("Keys:");
    while (iterator.hasNext()){
      System.out.println("\t" + iterator.next());
    }
  }

  @Test
  public void testKeysWithPrefix() {
    Iterator<String> iterator = trie.keysWithPrefix("sh").iterator();
    System.out.println("Keys with prefix of sh:");
    while (iterator.hasNext()){
      System.out.println("\t" + iterator.next());
    }
  }

  @Test
  public void testKeysThatMatch() {
    Iterator<String> iterator = trie.keysThatMatch("sh.").iterator();
    System.out.println("Keys match with sh.:");
    while (iterator.hasNext()){
      System.out.println("\t" + iterator.next());
    }
  }

  @Test
  public void testLongestPrefixOf() {
    assertTrue(trie.longestPrefixOf("sherry").equals("she"));
  }

  @Test
  public void testDelete() {
    trie.delete("shee");
    assertTrue(trie.size() == 7);
  }

}
