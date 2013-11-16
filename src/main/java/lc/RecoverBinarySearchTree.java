package lc;

import java.util.ArrayList;
import java.util.Collections;

import lc.util.TreeNode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
 * @author leili
 *
 */
public class RecoverBinarySearchTree {

  ArrayList<TreeNode> nodes;
  ArrayList<Integer> values;

  /**
   * O(n) space solution
   * @param root
   */
  public void recoverTree(TreeNode root) {
    nodes = new ArrayList<TreeNode>();
    values = new ArrayList<Integer>();
    inorderTraversal(root);
    Collections.sort(values);
    for (int i = 0; i < nodes.size(); i++)
      nodes.get(i).val = values.get(i);
  }

  private void inorderTraversal(TreeNode root) {
    if (root == null)
      return;

    inorderTraversal(root.left);
    nodes.add(root);
    values.add(root.val);
    inorderTraversal(root.right);
  }

}
