package lc;

import java.util.ArrayList;
import java.util.Stack;

import lc.util.TreeNode;

/**
 * Binary Tree Postorder Traversal Total Accepted: 36 Total Submissions: 104 My Submissions
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
 * @author leili
 *
 */
public class BinaryTreePostOrderTraversal {

  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null)
      return result;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    TreeNode prev = null;
    while (!stack.empty()) {
      TreeNode curNode = stack.peek();
      if (prev == null || prev.left == curNode || prev.right == curNode) {
        if (curNode.left != null)
          stack.push(curNode.left);
        else if (curNode.right != null)
          stack.push(curNode.right);
      } else if (curNode.left == prev) {
        if (curNode.right != null)
          stack.push(curNode.right);
      } else {
        result.add(curNode.val);
        stack.pop();
      }
      prev = curNode;
    }
    return result;
  }

}
