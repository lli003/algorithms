package basic.tree;

import lc.util.TreeNode;

/**
 * get a mirror of a binary tree
 * @author lli003
 *
 */
public class MirrorTree {
  
  public TreeNode mirror(TreeNode root){
    if (root == null || (root.left == null && root.right == null))
      return root;
    
    /* get mirrors of subtrees. */
    mirror(root.left);
    mirror(root.right);
    
    /* swap left and right subtree. */
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    
    return root;
  }

}
