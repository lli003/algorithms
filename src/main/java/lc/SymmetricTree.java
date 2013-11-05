package lc;

import lc.util.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
 * @author leili
 *
 */
public class SymmetricTree {
  
  /**
   * recursive solution
   * @param root
   * @return
   */
  public boolean isSymmetric(TreeNode root) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    if (root == null)
      return true;

    return symmetric(root.left, root.right);
  }

  private boolean symmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null)
      return true;
    else if ((left == null && right != null) || (left != null && right == null))
      return false;
    else if (left.val != right.val)
      return false;
    else
      return symmetric(left.left, right.right)
          && symmetric(left.right, right.left);
  }

}
