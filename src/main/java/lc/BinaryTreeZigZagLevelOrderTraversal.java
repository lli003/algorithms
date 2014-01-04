package lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import lc.util.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author leili
 *
 */
public class BinaryTreeZigZagLevelOrderTraversal {

  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null)
      return result;

    LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    list.offer(root);
    list.offer(null);
    ArrayList<Integer> rev = new ArrayList<Integer>();
    int count = 0;
    while (true) {
      TreeNode node = list.poll();
      // track level nodes
      if (node != null) {
        rev.add(node.val);
        if (node.left != null)
          list.offer(node.left);
        if (node.right != null)
          list.offer(node.right);
      }
      // if reaching the delimiter, then add to result
      else {
        if (count % 2 == 1) {
          Collections.reverse(rev);
          result.add(rev);
        } else {
          result.add(rev);
        }
        rev = new ArrayList<Integer>();
        if (list.size() == 0)
          break;
        list.offer(null); // add delimiter
        count++;
      }
    }

    return result;
  }

}
