package basic.tree;

import java.util.Iterator;
import java.util.Stack;

import lc.util.TreeNode;

/**
 * a binary search tree iterator based on in-order traversal
 * @author leili
 *
 */
public class BSTIterator implements Iterator<TreeNode> {

  private Stack<TreeNode> stack = new Stack<TreeNode>();
  private TreeNode root;

  private void pushLeft(TreeNode x) {
    while (x != null) {
      stack.push(x);
      x = x.left;
    }
  }

  public BSTIterator() {
    pushLeft(root);
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }

  public TreeNode next() {
    TreeNode x = stack.pop();
    pushLeft(x.right);
    return x;
  }

}
