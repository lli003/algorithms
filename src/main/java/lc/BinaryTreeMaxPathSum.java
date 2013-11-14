package lc;

import java.util.ArrayList;

import lc.util.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * @author leili
 *
 */
public class BinaryTreeMaxPathSum {

  public int maxPathSum(TreeNode root) {
    ArrayList<Integer> curMax = new ArrayList<Integer>();
    curMax.add(Integer.MIN_VALUE);
    getMax(root, curMax);
    return curMax.get(0);
  }

  private int getMax(TreeNode node, ArrayList<Integer> curMax) {
    if (node == null)
      return 0;

    int left = getMax(node.left, curMax);
    int right = getMax(node.right, curMax);
    int cur = Math.max(node.val, Math.max(node.val + left, node.val + right));
    curMax.add(0, Math.max(curMax.get(0), Math.max(cur, node.val + left + right)));
    return cur;
  }

}
