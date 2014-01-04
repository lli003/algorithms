package lc;

import lc.util.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 * @author leili
 *
 */
public class PartitionList {

  public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null)
      return head;

    ListNode left = new ListNode(0), right = new ListNode(0);
    ListNode curL = left, curR = right;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      if (cur.val < x) {
        curL.next = cur;
        curL = curL.next;
      } else {
        curR.next = cur;
        curR = curR.next;
        curR.next = null;
      }
      cur = next;
    }
    curL.next = right.next;
    return left.next;
  }

}
