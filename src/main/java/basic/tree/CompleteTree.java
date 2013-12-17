package basic.tree;

import lc.util.TreeNode;

/**
 * check if a binary tree is a complete tree
 * @author leili
 *
 */
public class CompleteTree {
  
  public boolean isCompleteTree(TreeNode root){
    if (root == null)
      return true;
    
    int ld = depth(root.left);
    int rd = depth(root.right);
    
    return (ld == rd && isCompleteTree(root.left) && isCompleteTree(root.right)); 
  }
  
  private int depth(TreeNode node){
    if (node == null)
      return 0;
    
    int ld = depth(node.left);
    int rd = depth(node.right);
    if (ld > rd)
      return ld + 1;
    else
      return rd + 1;
  }

}
