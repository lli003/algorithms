package lc;

import lc.util.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * @author lli003
 *
 */
public class MaximumDepthOfBT {
  
  /**
   * recursive solution
   * @param root
   * @return
   */
  public int maxDepth(TreeNode root){
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 1;
    
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

}
