package lc;

import lc.util.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * @author lli003
 *
 */
public class RemoveDuplicatesFromSortedList {
  
  public ListNode deleteDuplicates(ListNode head){
    if (head == null)
      return head;
    
    ListNode result = new ListNode(0), pre = result;
    int curVal = head.val;
    pre.next = new ListNode(curVal);
    pre = pre.next;
    
    while (head.next != null){
      head = head.next;
      if (head.val != curVal){
        pre.next = new ListNode(head.val);
        pre = pre.next;
        curVal = head.val;
      }
    }
    return result.next;
  }
}
