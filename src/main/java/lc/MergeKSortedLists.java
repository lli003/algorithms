package lc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import lc.util.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author leili
 * 
 */
public class MergeKSortedLists {

  /**
   * brute-force solution
   * 
   * @param lists
   * @return
   */
  public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if (lists == null || lists.size() == 0)
      return null;

    ListNode result = new ListNode(0);
    ListNode cur = result;

    int min = Integer.MAX_VALUE;
    int minIdx = -1;
    while (lists.size() > 0) {
      // find the minimal node of the current list
      for (int i = 0; i < lists.size(); i++) {
        if (lists.get(i) != null && lists.get(i).val < min) {
          min = lists.get(i).val;
          minIdx = i;
        }
      }
      if (minIdx == -1)
        return result.next;

      cur.next = new ListNode(min);
      cur = cur.next;
      ListNode minNode = lists.get(minIdx);
      minNode = minNode.next;
      if (minNode == null)
        lists.remove(minIdx);
      else
        lists.set(minIdx, minNode);
      min = Integer.MAX_VALUE;
      minIdx = -1;
    }
    return result.next;
  }

  /**
   * merge sort
   * 
   * @param lists
   * @return
   */
  public ListNode mergeKLists2(ArrayList<ListNode> lists) {
    if (lists == null || lists.size() == 0)
      return null;

    int last = lists.size() - 1;
    while (last > 0) {
      int cur = 0;
      while (cur < last) {
        lists.set(cur, mergeTwoLists(lists.get(cur++), lists.get(last--)));
      }
    }
    return lists.get(0);
  }

  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null)
      return null;
    ListNode res = new ListNode(0), cur = res;
    while (l1 != null || l2 != null) {
      int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
      int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;
      if (v1 < v2) {
        cur.next = new ListNode(v1);
        cur = cur.next;
        l1 = l1.next;
      } else if (v1 > v2) {
        cur.next = new ListNode(v2);
        cur = cur.next;
        l2 = l2.next;
      } else {
        cur.next = new ListNode(v1);
        cur = cur.next;
        cur.next = new ListNode(v2);
        cur = cur.next;
        l1 = l1.next;
        l2 = l2.next;
      }
    }
    return res.next;
  }
  
  public ListNode mergeKLists3(ArrayList<ListNode> lists){
    assert(lists != null);
    if (lists.size() == 0)
      return null;
    
    Comparator<ListNode> comparator = new Comparator<ListNode>(){
      public int compare(ListNode o1, ListNode o2) {
        if (o1.val < o2.val)
          return -1;
        else if (o1.val > o2.val)
          return 1;
        else
          return 0;
      }
    };
    
    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
    for (ListNode node : lists){
      if (node != null)
        heap.add(node);
    }
    
    ListNode head = null, cur = null;
    while (!heap.isEmpty()){
      if (head == null){
        head = heap.poll();
        cur = head;
      } else {
        cur.next = heap.poll();
        cur = cur.next;
      }
      if (cur.next != null)
        heap.add(cur.next);
    }
    return head;
  }

}
