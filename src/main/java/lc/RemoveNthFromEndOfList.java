package lc;

import lc.util.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
 * @author lli003
 *
 */
public class RemoveNthFromEndOfList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null)
      return head;

    // two pointers, one starts earlier, and the other starts later
    ListNode start = head, end = head;

    // move start n steps
    for (int i = 0; i < n; i++)
      start = start.next;

    // check if reaching to the end of the list
    if (start == null)
      return head.next;

    // move two pointers simultaneously
    while (start.next != null) {
      start = start.next;
      end = end.next;
    }

    // remove the node
    end.next = end.next.next;
    return head;
  }

}
