package lc;

import lc.util.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.s
 * @author leili
 *
 */
public class ConstructTreeFromInorderPostorder {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    if (inorder.length == 0 || inorder.length != postorder.length)
      return null;
    return build(inorder, 0, inorder.length - 1, postorder, 0,
        postorder.length - 1);
  }

  private TreeNode build(int[] inorder, int s1, int e1, int[] postorder,
      int s2, int e2) {
    if (s1 > e1 || s2 > e2)
      return null;
    TreeNode root = new TreeNode(postorder[e2]);
    int i = s1;
    for (; i <= e1; i++)
      if (inorder[i] == postorder[e2])
        break;
    root.left = build(inorder, s1, i - 1, postorder, s2, e2 + i - e1 - 1);
    root.right = build(inorder, i + 1, e1, postorder, e2 + i - e1, e2 - 1);
    return root;
  }

}
