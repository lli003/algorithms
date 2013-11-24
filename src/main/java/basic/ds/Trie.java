package basic.ds;

import java.util.LinkedList;
import java.util.Queue;

/**
 * a basic data structure of prefix tree, called trie
 * @author leili
 *
 * @param <Value>
 */
public class Trie<Value> {
  
  private static int R = 256; // radix
  private static Node root; // root of trie
  
  /* node class containing a value and an array of next pointers */
  private static class Node{
    private Object val;
    private Node[] next = new Node[R];
  }
  
  public int size(){
    return size(root);
  }
  
  /* lazy implementation of size() */
  private int size(Node x){
    if (x == null)
      return 0;
    int cnt = 0;
    if (x.val != null)
      cnt++;
    for (char c = 0; c < R; c++){
      cnt += size(x.next[c]);
    }
    return cnt;
  }
  
  @SuppressWarnings("unchecked")
  public Value get(String key){
    Node x = get(root, key, 0);
    if (x == null)
      return null;
    return (Value) x.val;
  }
  
  /* recursive solution to get value associated with key in the subtrie rooted at x. */
  private Node get(Node x, String key, int d){
    if (x == null)
      return null;
    if (d == key.length())
      return x;
    char c = key.charAt(d);
    return get(x.next[c], key, d+1);
  }
  
  public void put(String key, Value val){
    root = put(root, key, val, 0);
  }
  
  /* recursive solution to change value associated with key if in subtrie rooted at x. */
  private Node put(Node x, String key, Value val, int d){
    if (x == null)
      x = new Node();
    if (d == key.length()){
      x.val = val;
      return x;
    }
    char c = key.charAt(d);
    x.next[c] = put(x.next[c], key, val, d+1);
    return x;
  }
  
  /* get all the keys */
  public Iterable<String> keys(){
    return keysWithPrefix("");
  }
  
  /* get the keys with the given prefix. */
  public Iterable<String> keysWithPrefix(String pre){
    Queue<String> q = new LinkedList<String>();
    collect(get(root, pre, 0), pre, q);
    return q;
  }
  
  /* recursive solution to obtain keys. */
  private void collect(Node x, String pre, Queue<String> q){
    if (x == null)
      return;
    if (x.val != null)
      q.offer(pre);
    for (char c = 0; c < R; c++)
      collect(x.next[c], pre+c, q);
  }
  
  /* get the keys that match with the given pattern. */
  public Iterable<String> keysThatMatch(String pat){
    Queue<String> q = new LinkedList<String>();
    collect(root, "", pat, q);
    return q;
  }
  
  private void collect(Node x, String pre, String pat, Queue<String> q){
    int d = pre.length();
    if (x == null)
      return;
    if (d == pat.length() && x.val != null)
      q.offer(pre);
    if (d == pat.length())
      return;
    
    char next = pat.charAt(d);
    for (char c = 0; c < R; c++){
      if (next == '.' || next == c)
        collect(x.next[c], pre + c, pat, q);
    }
  }
  
  /* get the longest key that is a prefix of the given string. */
  public String longestPrefixOf(String s){
    int length = search(root, s, 0, 0);
    return s.substring(0, length);
  }
  
  private int search(Node x, String s, int d, int length){
    if (x == null)
      return length;
    if (x.val != null)
      length = d;
    if (d == s.length())
      return length;
    char c = s.charAt(d);
    return search(x.next[c], s, d+1, length);
  }
  
  /* delete a key from the trie. */
  public void delete(String key){
    root = delete(root, key, 0);
  }
  
  private Node delete(Node x, String key, int d){
    if (x == null)
      return null;
    if (d == key.length())
      x.val = null;
    else{
      char c = key.charAt(d);
      x.next[c] = delete(x.next[c], key, d+1);
    }
    
    if (x.val != null)
      return x;
    
    for (char c = 0; c < R; c++)
      if (x.next[c] != null)
        return x;
    
    return null;
  }

}
