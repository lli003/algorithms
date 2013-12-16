package basic.tree;

import java.util.HashSet;

import lc.util.TreeNode;

public class LCAWithParent {
  
  public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
    if (root == null){
      return root;
    }
    
    /* store the vistied nodes. */
    HashSet<TreeNode> visited = new HashSet<TreeNode>();
    while (p != null || q != null){
      if (p != null){
        if (visited.contains(p)){
          return p;
        }
        visited.add(p);
        p = p.parent;
      }
      if (q != null){
        if (visited.contains(q)){
          return q;
        }
        visited.add(q);
        q = q.parent;
      }
    }
    return null;
  }

}
