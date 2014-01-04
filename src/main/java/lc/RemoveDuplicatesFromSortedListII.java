package lc;

import lc.util.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 * @author leili
 *
 */
public class RemoveDuplicatesFromSortedListII {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode res = new ListNode(0), tail = res, pre = head, cur = head;
    while (cur != null && cur.next != null) {
      while (cur.next != null && cur.val == cur.next.val)
        cur = cur.next;
      if (pre == cur) {
        tail.next = pre;
        tail = tail.next;
      }
      pre = cur.next;
      cur = cur.next;
    }
    tail.next = cur;
    return res.next;
  }

}
