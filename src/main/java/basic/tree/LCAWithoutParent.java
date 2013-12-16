package basic.tree;

import lc.util.TreeNode;

public class LCAWithoutParent {
  
  public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
    if (root == null)
      return null;
    
    if (root == p || root == q)
      return root;
    
    TreeNode left = LCA(root.left, p, q);
    TreeNode right = LCA(root.right, p, q);
    
    /* both p and q are in different subtrees. */
    if (left != null && right != null)
      return root;
    
    return left != null ? left : right;
  }

}
