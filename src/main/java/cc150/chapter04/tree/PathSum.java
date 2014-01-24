package cc150.chapter04.tree;

import java.util.ArrayList;

import lc.util.TreeNode;

/**
 * You are given a binary tree in which each node contains a value. 
 * Design an algorithm to print all paths which sum up to that value. 
 * Note that it can be any path in the tree - it does not have to start at the root.
 * @author lli003
 *
 */
public class PathSum {
  
  public void findSum(TreeNode head, int sum, ArrayList<Integer> buff, int level){
    if (head == null)
      return;
    int tmp = sum;
    buff.add(head.val);
    for (int i = level; i > -1; i--){
      tmp -= buff.get(i);
      if (tmp == 0)
        print(buff, i, level);
    }
    @SuppressWarnings("unchecked")
    ArrayList<Integer> c1 = (ArrayList<Integer>) buff.clone();
    @SuppressWarnings("unchecked")
    ArrayList<Integer> c2 = (ArrayList<Integer>) buff.clone();
    findSum(head.left, sum, c1, level+1);
    findSum(head.right, sum, c2, level+1);
  }
  
  private void print(ArrayList<Integer> buff, int level, int i2){
    for (int i = level; i <= i2; i++)
      System.out.println(buff.get(i) + " ");
    System.out.println();
  }

}
