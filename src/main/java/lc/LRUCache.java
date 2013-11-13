package lc;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * @author leili
 * 
 */
public class LRUCache {

  class Node {
    Node prev;
    Node next;
    int key;
    int value;
  }

  private Node head = null;
  private int capacity = 0;
  private HashMap<Integer, Node> map = null;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<Integer, Node>();
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node n = map.get(key);
      detach(n);
      attach(n);
      return n.value;
    } else {
      return -1;
    }
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      Node n = map.get(key);
      detach(n);
      n.value = value;
      attach(n);
    } else {
      Node n = new Node();
      n.key = key;
      n.value = value;
      if (map.size() < capacity) {
        attach(n);
        map.put(key, n);
      } else {
        attach(n);
        map.put(key, n);
        Node oldest = head.prev;
        detach(oldest);
        map.remove(oldest.key);
      }
    }
  }

  private void attach(Node n) {
    if (head == null) {
      head = n;
      head.next = n;
      head.prev = n;
    } else {
      n.prev = head.prev;
      head.prev.next = n;
      n.next = head;
      head.prev = n;
      head = n;
    }
  }

  private void detach(Node n) {
    if (n == head)
      head = head.next;
    n.prev.next = n.next;
    n.next.prev = n.prev;
  }

}
