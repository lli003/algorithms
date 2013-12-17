package basic.linkedlist;

import lc.util.ListNode;

public class ReverseLinkedList {
  
  /**
   * recursive solution
   * @param head
   * @return
   */
  public ListNode reverse(ListNode head){
    if (head == null)
      return null;
    
    if (head.next == null)
      return head;
    
    /* get the second node. */
    ListNode secondNode = head.next;
    
    /* unlink head from the list. */
    head.next = null;
    
    /* recursively reverse the left nodes. */
    ListNode reverseRest = reverse(secondNode);
    
    /* link head to the end. */
    secondNode.next = head;
    
    return reverseRest;
  }
  
  /**
   * iterative solution
   * @param head
   * @return
   */
  public ListNode reverse2(ListNode head){
    ListNode prev = null;
    
    /* swap two adjacent nodes. */
    while (head != null){
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    
    return prev;
  }

}
