package lc;

import java.util.ArrayList;
import java.util.LinkedList;

import lc.util.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * @author lli003
 *
 */
public class BinaryTreeLevelOrderTraversal {
  
  /**
   * iterative solution
   * using a Linkedlist (Queue) to track the accessed node in one level
   * @param root
   * @return
   */
  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null)
      return result;
    
    LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    list.offer(root);
    list.offer(null);
    ArrayList<Integer> rev = new ArrayList<Integer>();
    
    while(true){
      TreeNode node = list.poll();
      // track level nodes
      if (node != null){
        rev.add(node.val);
        if (node.left != null)
          list.offer(node.left);
        if (node.right != null)
          list.offer(node.right);
      } 
      // if reaching the delimiter, then add to result
      else {
        result.add(rev);
        rev = new ArrayList<Integer>();
        if (list.size() == 0)
          break;
        list.offer(null); // add delimiter
      }
    }
    
    return result;
  }

}
