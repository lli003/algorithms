package lc;

import lc.util.ListNode;
import lc.util.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author lli003
 *
 */
public class ConvertSortedListToBST {
  
  /**
   * recursive solution
   * @param head
   * @return
   */
  public TreeNode sortedListToBST(ListNode head){
    ListNode cur = head;
    int n = 0;
    while (cur != null){
      cur = cur.next;
      n++;
    }
    return convert(head, 0, n-1);
  }
  
  private TreeNode convert(ListNode head, int start, int end){
    if (start > end)
      return null;
    
    int mid = start + (end - start)/2;
    TreeNode left = convert(head, start, mid - 1);
    TreeNode parent = new TreeNode(head.val);
    parent.left = left;
    if (head.next != null){
      head.val = head.next.val;
      head.next = head.next.next;
    }
    parent.right = convert(head, mid + 1, end);
    return parent;
  }

}
