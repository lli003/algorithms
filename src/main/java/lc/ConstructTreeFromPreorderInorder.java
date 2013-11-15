package lc;

import lc.util.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * @author leili
 *
 */
public class ConstructTreeFromPreorderInorder {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // boundary
    if (preorder.length == 0 || preorder.length != inorder.length)
      return null;
    return build(preorder, 0, preorder.length - 1, inorder, 0,
        inorder.length - 1);
  }

  private TreeNode build(int[] preorder, int s1, int e1, int[] inorder, int s2,
      int e2) {
    if (s1 > e1 || s2 > e2)
      return null;
    TreeNode root = new TreeNode(preorder[s1]);
    int i = 0;
    for (; i < e2; i++)
      if (inorder[i] == preorder[s1])
        break;
    root.left = build(preorder, s1 + 1, s1 + i - s2, inorder, s2, i - 1);
    root.right = build(preorder, s1 + i - s2 + 1, e1, inorder, i + 1, e2);
    return root;
  }

}
