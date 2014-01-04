package lc;

import lc.util.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 * @author leili
 *
 */
public class ReverserListII {

  public ListNode reverseBetween(ListNode head, int m, int n) {
    int index = 0;
    ListNode root = new ListNode(0);
    root.next = head;
    ListNode cur_node = root;
    ListNode pre_m_node = root, m_node = root;
    /* get the node at m-th position. */
    while (index < m) {
      index++;
      if (index == m) {
        pre_m_node = cur_node;
        m_node = cur_node.next;
      }
      cur_node = cur_node.next;
    }

    index++;
    cur_node = m_node.next;
    /* reverse the nodes between m and n. */
    while (index <= n) {
      m_node.next = cur_node.next;
      cur_node.next = pre_m_node.next;
      pre_m_node.next = cur_node;
      cur_node = m_node.next;
      index++;
    }

    return root.next;
  }

}
