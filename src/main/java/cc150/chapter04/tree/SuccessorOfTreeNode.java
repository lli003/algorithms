package cc150.chapter04.tree;

import lc.util.TreeNode;

public class SuccessorOfTreeNode {

  public TreeNode inorderSuccessor(TreeNode e) {
    if (e != null) {

      TreeNode suc;
      if (e.parent == null || e.right != null) {
        suc = leftMostChild(e.right);
      } else {
        while ((suc = e.parent) != null){
          if (suc.left == e)
            break;
          e = suc;
        }
      }
      return suc;
    }
    return null;
  }

  private TreeNode leftMostChild(TreeNode e) {
    if (e == null)
      return null;
    while (e.left != null)
      e = e.left;
    return e;
  }

}
