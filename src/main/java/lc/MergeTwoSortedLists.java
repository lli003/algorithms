package lc;

import lc.util.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author lli003
 *
 */
public class MergeTwoSortedLists {
  
  public ListNode mergeTwoLists(ListNode l1, ListNode l2){
    ListNode pre = new ListNode(0), cur = pre;
    
    // iterate two lists
    while (l1 != null || l2 != null){
      int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
      int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;
      
      if (v1 > v2){
        cur.next = new ListNode(v2);
        cur = cur.next;
        l2 = l2.next;
      } else if (v1 < v2){
        cur.next = new ListNode(v1);
        cur = cur.next;
        l1 = l1.next;
      } else {
        cur.next = new ListNode(v1);
        cur = cur.next;
        cur.next = new ListNode(v2);
        cur = cur.next;
        l1 = l1.next;
        l2 = l2.next;
      }
    }
    
    return pre.next;
  }
  
}
