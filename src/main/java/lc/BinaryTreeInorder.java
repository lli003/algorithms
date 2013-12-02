package lc;

import java.util.ArrayList;
import java.util.Stack;

import lc.util.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * @author lli003
 * 
 */
public class BinaryTreeInorder {

  /**
   * iterative solution
   * 
   * @param root
   * @return
   */
  public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null)
      return result;

    // maintain a stack to store the left child
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (!stack.empty() || root != null) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        result.add(root.val);
        root = root.right;
      }
    }

    return result;
  }

  /**
   * iterative solution with constant space
   * threaded tree
   * 
   * @param root
   * @return
   */
  public ArrayList<Integer> inorderTraversal2(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null)
      return result;

    TreeNode cur = root;
    while (cur != null) {
      /* if no left child, then vist itself. */
      if (cur.left == null) {
        result.add(cur.val);
        cur = cur.right;
      }
      /* if there is left child */
      else {
        TreeNode left = cur.left;
        /* get the rightmost node of the left child, i.e., the predecessor. */
        while (left.right != null) {
          if (left.right == cur)
            break;
          left = left.right;
        }
        /* if cur's predecessor has been visited. */
        if (left.right == cur) {
          result.add(cur.val);
          left.right = null;
          cur = cur.right;
        }
        /* if the right pointer is null, then set its value to thread the tree. */
        else if (left.right == null) {
          left.right = cur;
          cur = cur.left;
        }
      }
    }
    return result;
  }

}
