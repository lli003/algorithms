package basic.tree;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lc.util.TreeNode;

public class BinaryTreeSerializationDeserialization {
  
  public void writeBinaryTree(TreeNode root, ObjectOutputStream out) throws IOException{
    if (root == null){
      out.writeObject("#");
      return;
    } else {
      out.writeObject(root.val);
      writeBinaryTree(root.left, out);
      writeBinaryTree(root.right, out);
    }
  }
  
  public TreeNode readBinaryTree(ObjectInputStream in) throws ClassNotFoundException, IOException{
    String token = (String)in.readObject();
    if (token.equals("#")){
      return null;
    } else {
      TreeNode root = new TreeNode(Integer.parseInt(token));
      readBinaryTreeHelper(root, true, in);
      readBinaryTreeHelper(root, false, in);
      return root;
    }
  }
  
  public void readBinaryTreeHelper(TreeNode root, boolean isLeft, ObjectInputStream in) throws ClassNotFoundException, IOException{
    String token = (String)in.readObject();
    if (token.equals("#")){
      return;
    } else {
      TreeNode node = new TreeNode(Integer.parseInt(token));
      if (isLeft)
        root.left = node;
      else
        root.right = node;
      readBinaryTreeHelper(node, true, in);
      readBinaryTreeHelper(node, false, in);
    }
  }

}
