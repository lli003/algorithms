package cc150.chapter04;

import lc.util.TreeNode;

/**
 * given two binary trees T1 and T2, T1 is very large, check if T2 is a subtree of T1
 * @author lli003
 *
 */
public class Subtree {
  
  public boolean isSubtree(TreeNode t1, TreeNode t2){
    if (t2 == null)
      return true;
    return subtree(t1, t2);
  }
  
  private boolean subtree(TreeNode t1, TreeNode t2){
    if (t1 == null)
      return false;
    if (t1.val == t2.val)
      if (matchTree(t1, t2))
        return true;
    return subtree(t1.left, t2) || subtree(t1.right, t2);
  }
  
  private boolean matchTree(TreeNode t1, TreeNode t2){
    if (t2 == null && t1 == null)
      return true;
    if (t1 == null || t2 == null)
      return false;
    if (t1.val != t2.val)
      return false;
    return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
  }

}
