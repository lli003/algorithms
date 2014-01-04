package lc;

import lc.util.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 * @author leili
 *
 */
public class PopulatingNextRightPointerII {

  public void connect(TreeLinkNode root) {
    if (root != null)
      root.next = null;
    rec(root);
  }

  private void rec(TreeLinkNode node) {
    if (node == null)
      return;
    else {
      if (node.right != null) {
        node.right.next = helperRight(node);
      }
      if (node.left != null) {
        node.left.next = helperLeft(node);
      }
      rec(node.right);
      rec(node.left);
    }
  }

  private TreeLinkNode helperRight(TreeLinkNode node) {
    TreeLinkNode tmp = node;
    while (tmp.next != null) {
      if (tmp.next.left != null)
        return tmp.next.left;
      else if (tmp.next.right != null)
        return tmp.next.right;
      tmp = tmp.next;
    }
    return null;
  }

  private TreeLinkNode helperLeft(TreeLinkNode node) {
    if (node.right != null)
      return node.right;
    else
      return helperRight(node);
  }

}
