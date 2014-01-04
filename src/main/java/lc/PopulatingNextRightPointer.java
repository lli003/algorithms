package lc;

import lc.util.TreeLinkNode;

/**
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL. Initially, all next
 * pointers are set to NULL.
 * 
 * You may only use constant extra space. You may assume that it is a perfect
 * binary tree (i.e., all leaves are at the same level, and every parent has two
 * children).
 * 
 * @author lli003
 * 
 */
public class PopulatingNextRightPointer {

  /**
   * use a recursive way
   * 
   * @param root
   */
  public void connect(TreeLinkNode root) {
    if (root == null || (root.left == null && root.right == null))
      return;

    root.left.next = root.right;
    if (root.next != null)
      root.right.next = root.next.left;

    connect(root.left);
    connect(root.right);
  }

  /**
   * iterative way
   * use a pre pointer to store the previous node's right child, for linking it to the next pointer of the node's left child
   * @param root
   */
  public void connect2(TreeLinkNode root) {
    TreeLinkNode start = root;
    while (start != null) {
      TreeLinkNode p = start;
      start = p.left;
      if (start == null)
        break;
      TreeLinkNode pre = null;
      while (p != null) {
        if (pre != null)
          pre.next = p.left;
        p.left.next = p.right;
        pre = p.right;
        p = p.next;
      }
    }
  }

}
