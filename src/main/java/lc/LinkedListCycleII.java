package lc;

import lc.util.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * @author leili
 * 
 */
public class LinkedListCycleII {

  /**
   * record the meeting point then start to walk from head and meeting point
   * till they meet
   * 
   * @param head
   * @return
   */
  public ListNode detectCycle(ListNode head) {
    if (head == null)
      return head;

    ListNode slow = head;
    ListNode fast = head;
    while (true) {
      if (fast == null || fast.next == null)
        return null;
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast)
        break;
    }

    if (slow == fast) {
      slow = head;
      while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
      }
      return slow;
    } else {
      return null;
    }
  }

}
