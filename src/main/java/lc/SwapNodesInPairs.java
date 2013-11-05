package lc;

import lc.util.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author lli003
 *
 */
public class SwapNodesInPairs {
  
  public ListNode swapPairs(ListNode head){
    if (head == null || head.next == null)
      return head;
    
    ListNode pre = head;
    ListNode cur = head.next;
    
    while (cur != null){
      pre.next = cur.next;
      cur.next = pre;
      if (head == pre)
        head = cur;
      
      ListNode tmp = pre.next;
      if (tmp == null || tmp.next == null)
        return head;
      cur = tmp.next;
      pre.next = cur;
      pre = tmp;
    }
    
    return head;
  }

}
