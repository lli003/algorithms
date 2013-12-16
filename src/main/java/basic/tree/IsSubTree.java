package basic.tree;

import lc.util.TreeNode;

/**
 * given two trees t1 and t2, check if t2 is a subtree of t1
 * @author lli003
 *
 */
public class IsSubTree {
  
  public boolean isSubTree(TreeNode t1, TreeNode t2){
    if (t1 == t2)
      return true;
    if (t2 == null)
      return true;
    if (t1 == null)
      return false;
    
    return isEqual(t1, t2) || isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
  }
  
  private boolean isEqual(TreeNode t1, TreeNode t2){
    if (t1 == t2)
      return true;
    if (t1 == null || t2 == null)
      return false;
    if (t1.val != t2.val)
      return false;
    return isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
  }

}
