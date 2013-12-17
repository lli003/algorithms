package basic.linkedlist;

import lc.util.ListNode;

/**
 * get the length of a linkedlist that may contain a cycle
 * @author lli003
 *
 */
public class LengthOfLinkedListWithCycle {
  
  public int lengthOfLinkedListWithCycle(ListNode head){
    if (head == null)
      return 0;
    
    ListNode fast = head, slow = head;
    int length = 1;
    
    while(true){
      if (fast == null || fast.next == null)
        break;
      slow = slow.next;
      head = head.next.next;
      if (slow == fast)
        break;
    }
    
    if (slow == fast){
      /* up to meeting point. */
      slow = head;
      while (slow != head){
        slow = slow.next;
        head = head.next;
        length++;
      }
      
      /* get the length of cycle. */
      while (fast.next != slow){
        fast = fast.next;
        length++;
      }
      length++;
    } else {
      fast = head;
      while (fast != null){
        fast = fast.next;
        length++;
      }
    }
    
    return length;
  }

}
