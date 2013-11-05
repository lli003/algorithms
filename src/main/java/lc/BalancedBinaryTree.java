package lc;

import lc.util.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @author lli003
 *
 */
public class BalancedBinaryTree {
  
  /**
   * recursive solution
   * @param root
   * @return
   */
  public boolean isBalanced(TreeNode root){
    if (root == null)
      return true;
    
    int left = height(root.left);
    int right = height(root.right);
    
    if (Math.abs(left - right) > 1)
      return false;
    else
      return isBalanced(root.left) && isBalanced(root.right);
  }
  
  private int height(TreeNode node){
    if (node == null)
      return 0;
    
    return Math.max(height(node.left), height(node.right)) + 1;
  }

}
