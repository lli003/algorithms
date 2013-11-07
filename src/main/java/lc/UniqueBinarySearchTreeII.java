package lc;

import java.util.ArrayList;

import lc.util.TreeNode;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author leili
 *
 */
public class UniqueBinarySearchTreeII {

  public ArrayList<TreeNode> generateBSTs(int n) {
    return generate(1, n);
  }

  private ArrayList<TreeNode> generate(int start, int end) {
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    if (start > end) {
      list.add(null);
      return list;
    }

    for (int i = start; i <= end; i++) {
      for (TreeNode left : generate(start, i - 1)) {
        for (TreeNode right : generate(i + 1, end)) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          list.add(root);
        }
      }
    }
    return list;
  }

}
