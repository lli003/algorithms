package cc150.chapter04;

import lc.util.TreeNode;

public class MinimalHeightBinaryTreeFromArray {
  
  public TreeNode createTree(int[] arr){
    return addToTree(arr, 0, arr.length - 1);
  }
  
  private TreeNode addToTree(int[] arr, int start, int end){
    int mid = start + (end-start)/2;
    TreeNode node = new TreeNode(arr[mid]);
    node.left = addToTree(arr, start, mid - 1);
    node.right = addToTree(arr, mid + 1, end);
    return node;
  }

}
