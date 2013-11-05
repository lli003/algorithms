package lc;

import lc.util.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author lli003
 *
 */
public class ConvertSortedArrayToBST {
  
  /**
   * recursive solution
   * @param num
   * @return
   */
  public TreeNode sortedArrayToBST(int[] num){
    return convert(num, 0, num.length - 1);
  }
  
  private TreeNode convert(int[] num, int start, int end){
    if (start > end)
      return null;
    
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(num[mid]);
    root.left = convert(num, start, mid - 1);
    root.right = convert(num, mid + 1, end);
    return root;
  }
}
