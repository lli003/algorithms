package lc;

import java.util.LinkedList;

import lc.util.TreeLinkNode;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * @author lli003
 *
 */
public class PopulatingNextRightPointer {
  
  public void connect(TreeLinkNode root){
    if (root == null)
      return;
    
    LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
    LinkedList<TreeLinkNode> newList = new LinkedList<TreeLinkNode>();
    
    list.offer(root);
    TreeLinkNode leftMostNode = root.left;
    
    while (leftMostNode != null){
      for (TreeLinkNode node : list){
        newList.offer(node.left);
        newList.offer(node.right);
      }
      connectNodes(list);
      list = newList;
      newList = new LinkedList<TreeLinkNode>();
      leftMostNode = list.peek().left;
    }
    connectNodes(list);
  }
  
  private void connectNodes(LinkedList<TreeLinkNode> list){
    if (list.size() == 1){
      TreeLinkNode node = list.poll();
      node.next = null;
      return;
    }
    TreeLinkNode pre = list.poll();
    pre.next = list.peek();
    connectNodes(list);
  }

}
