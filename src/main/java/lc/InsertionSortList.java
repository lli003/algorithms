package lc;

import lc.util.ListNode;

/**
 * Sort a linked list using insertion sort.
 * @author leili
 *
 */
public class InsertionSortList {
  
  public ListNode insertionSortList(ListNode head){
    if (head == null)
        return head;
    
    ListNode result = new ListNode(Integer.MIN_VALUE);
    ListNode pre = result;
    ListNode cur = null;
    ListNode next;
    
    while (head != null){
      next = head;
      head = head.next;
      next.next = null;
      pre = result;
      cur = pre.next;
      while (cur != null && cur.val < next.val){
        cur = cur.next;
        pre = pre.next;
      }
      pre.next = next;
      next.next = cur;
    }
    
    return result.next;
  }
  
}
