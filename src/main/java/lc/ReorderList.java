package lc;

import lc.util.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * @author leili
 *
 */
public class ReorderList {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null)
      return;

    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode p1 = head, p2 = slow.next;
    slow.next = null;

    p2 = reverseList(p2);

    mergeTwoLists(head, p1, p2);
  }

  private ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode cur = head.next, pre = head;
    ListNode tmp = null;
    pre.next = null;

    while (cur != null) {
      tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }

    return pre;
  }

  private void mergeTwoLists(ListNode head, ListNode p1, ListNode p2) {
    if (p2 == null)
      return;

    head = new ListNode(0);
    ListNode cur = head;
    int count = 0;
    while (p1 != null && p2 != null) {
      if (count % 2 == 0) {
        cur.next = p1;
        cur = cur.next;
        p1 = p1.next;
      } else {
        cur.next = p2;
        cur = cur.next;
        p2 = p2.next;
      }
      count++;
    }

    while (p1 != null) {
      cur.next = p1;
      cur = cur.next;
      p1 = p1.next;
    }

    while (p2 != null) {
      cur.next = p2;
      cur = cur.next;
      p2 = p2.next;
    }

    head = head.next;
  }

}
