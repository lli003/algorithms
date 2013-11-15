package lc;

import lc.util.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * @author leili
 *
 */
public class FlattenBinaryTreeToLinkedList {

  public void flatten(TreeNode root) {
    if (root == null)
      return;

    TreeNode left = root.left;
    TreeNode right = root.right;

    if (left != null) {
      root.right = left;
      root.left = null;
      TreeNode rightmost = left;
      while (rightmost.right != null)
        rightmost = rightmost.right;
      rightmost.right = right;
    }
    flatten(root.right);
  }

}
