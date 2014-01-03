package lc;

import lc.util.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author leili
 *
 */
public class SortList {
  
  /**
   * merge sort
   * @param head
   * @return
   */
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
        return head;
    
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    /* separate the list into two lists. */
    ListNode newHead = slow.next;
    slow.next = null;
    
    /* sort two lists. */
    head = sortList(head);
    newHead = sortList(newHead);
    
    /* combine two lists. */
    return mergeTwoLists(head, newHead);
}

private ListNode mergeTwoLists(ListNode l1, ListNode l2){
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    
    ListNode c1 = l1.val <= l2.val ? l1 : l2;
    ListNode c2 = l1.val <= l2.val ? l2 : l1;
    while (c1.next != null && c2 != null){
        if (c1.val <= c2.val && c2.val <= c1.next.val){
            ListNode tmp = c2.next;
            c2.next = c1.next;
            c1.next = c2;
            c1 = c1.next;
            c2 = tmp;
        } else
            c1 = c1.next;
    }
    if (c1.next == null)
        c1.next = c2;
    return l1.val <= l2.val ? l1 : l2;
}

}
