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
  
  /**
   * constant space
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    
    /* two pointers, one stores the smaller node from one list, the other stores the larger node from the other list. */
    ListNode c1 = l1.val <= l2.val ? l1 : l2;
    ListNode c2 = l1.val <= l2.val ? l2 : l1;
    
    /* go through two lists. */
    while (c1.next != null && c2 != null){
        /* if c2 is in between c1 and c1.next. */
        if (c1.val <= c2.val && c2.val <= c1.next.val){
            ListNode tmp = c2.next;
            c2.next = c1.next;
            c1.next = c2;
            c1 = c1.next;
            c2 = tmp;
        } else {
            c1 = c1.next;
        }
    }
    if (c1.next == null){
        c1.next = c2;
    }
    return l1.val <= l2.val ? l1 : l2;
  }
  
}
