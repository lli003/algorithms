package lc;

import java.util.ArrayList;
import java.util.Stack;

import lc.util.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * @author lli003
 *
 */
public class BinaryTreeInorder {
  
  /**
   * iterative solution
   * @param root
   * @return
   */
  public ArrayList<Integer> inorderTraversal(TreeNode root){
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null)
      return result;
    
    // maintain a stack to store the left child
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (!stack.empty() || root != null){
      if (root != null){
        stack.push(root);
        root = root.left;
      } else{
        root = stack.pop();
        result.add(root.val);
        root = root.right;
      }
    }
    
    return result;
  }

}
