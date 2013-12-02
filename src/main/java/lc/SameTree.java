package lc;

import java.util.Stack;

import lc.util.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * @author lli003
 *
 */
public class SameTree {
  
  public boolean isSameTree(TreeNode p, TreeNode q){
    if (p == null && q == null)
      return true;
    if ((p != null && q == null) || (p == null && q != null))
      return false;
    if (p.val != q.val)
      return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
  
  /**
   * iterative solution
   * @param p
   * @param q
   * @return
   */
  public boolean isSameTree2(TreeNode p, TreeNode q){
    Stack<TreeNode> pstack = new Stack<TreeNode>();
    Stack<TreeNode> qstack = new Stack<TreeNode>();
    pstack.push(p);
    qstack.push(q);
    
    while(!pstack.isEmpty() && !qstack.isEmpty()){
        p = pstack.pop();
        q = qstack.pop();
        if (p != null && q != null && p.val == q.val){
            pstack.push(p.right);
            pstack.push(p.left);
            qstack.push(q.right);
            qstack.push(q.left);
        } else if (p == null && q == null)
            continue;
        else
            return false;
    }
    if (!pstack.isEmpty() || !qstack.isEmpty())
        return false;
    
    return true;
  }
}

