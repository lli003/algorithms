package lc;

import lc.util.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 * @author leili
 *
 */
public class ValidateBST {

  public boolean isValidBST(TreeNode root) {
    return validate(root, null, null);
  }

  private boolean validate(TreeNode node, Integer lower, Integer upper) {
    if (node == null)
      return true;
    if (lower != null && node.val <= lower)
      return false;
    if (upper != null && node.val >= upper)
      return false;
    return validate(node.left, lower, node.val)
        && validate(node.right, node.val, upper);
  }

}
