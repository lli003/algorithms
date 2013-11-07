package lc;

import java.util.ArrayList;

import lc.util.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / / \ 11 13
 * 4 / \ / \ 7 2 5 1 return [ [5,4,11,2], [5,8,4,5] ] Discuss
 * 
 * 
 * @author lli003
 * 
 */
public class PathSumII {

  /**
   * depth-first search
   * @param root
   * @param sum
   * @return
   */
  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null)
      return result;
    ArrayList<Integer> rev = new ArrayList<Integer>();

    // only one node in the tree
    if (root.val == sum && root.left == null && root.right == null) {
      rev.add(root.val);
      result.add(rev);
      return result;
    }
    
    // depth-first search
    rev.add(root.val);
    dfs(root.left, sum - root.val, rev, result);
    dfs(root.right, sum - root.val, rev, result);
    return result;
  }

  private void dfs(TreeNode root, int sum, ArrayList<Integer> rev,
      ArrayList<ArrayList<Integer>> result) {
    if (root == null)
      return;
    rev.add(root.val);
    if (root.val == sum && root.left == null && root.right == null) {
      result.add(new ArrayList<Integer>(rev));
      rev.remove(rev.size() - 1); // pop up 
      return;
    }

    dfs(root.left, sum - root.val, rev, result);
    dfs(root.right, sum - root.val, rev, result);
    rev.remove(rev.size() - 1); // pop up
  }

}
