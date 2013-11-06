package lc;

import java.util.ArrayList;
import java.util.Stack;

import lc.util.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * @author leili
 *
 */
public class BinaryTreePreorder {
  
  public ArrayList<Integer> preorderTraversal(TreeNode root){
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null)
      return result;
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.empty() || root != null){
      if (root != null){
        result.add(root.val);
        if (root.right != null)
          stack.push(root.right);
        root = root.left;
      } else 
        root = stack.pop();
    }
    
    return result;
  }
  
}
