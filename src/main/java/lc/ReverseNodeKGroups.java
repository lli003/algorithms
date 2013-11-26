package lc;

import java.util.Stack;

import lc.util.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 * @author lli003
 *
 */
public class ReverseNodeKGroups {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k <= 1)
      return head;

    ListNode cur = head;
    ListNode top = null;
    ListNode temp = null;

    /* maintain the k nodes in a stack. */
    Stack<ListNode> stack = new Stack<ListNode>();

    while (cur != null) {
      /* put the k nodes into stack. */
      for (int i = 0; i < k; i++) {
        /* if not reaching the k-th node, then do not reverse the left segment. */
        if (cur == null) {
          if (top == null)
            return head;
          return top;
        }
        stack.push(cur);
        cur = cur.next;
      }

      /* get k nodes from stack and link them in a reverse order. */
      while (!stack.empty()) {
        if (top == null) {
          top = stack.pop();
          temp = top;
        } else {
          temp.next = stack.pop();
          temp = temp.next;
        }
      }

      /*
       * link the pointer of the last node to the start node of the next segment.
       */
      temp.next = cur;
    }
    return top;
  }

}
