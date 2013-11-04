package lc;

import lc.util.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * @author lli003
 *
 */
public class LinkedListCycle {
  
  public boolean hasCycle(ListNode head){
    if (head == null || head.next == null)
      return false;
    
    // two pointers to scan linked list
    ListNode slow = head, fast = head.next;
    while (slow != null && fast != null && fast.next != null){
      if (slow == fast)
        return true;
      slow = slow.next;
      fast = fast.next.next;
    }
    
    return false;
  }

}
