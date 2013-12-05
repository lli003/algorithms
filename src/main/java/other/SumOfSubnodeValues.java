package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * the input contains a list of instances with format:
 * id, parent, value
 * print the sum of values of a node and the nodes in its subtree
 * @author leili
 *
 */

class Node{
  int id;
  int parent;
  int weight;
  Node(int id, int parent, int value){
    this.id = id;
    this.parent = parent;
    this.weight = value;
  }
}

public class SumOfSubnodeValues {
  public void sumNodesInSubTrees(List<Node> nodes){
    Map<Integer,Integer> nodeMap = new HashMap<Integer,Integer>();
    Map<Integer,Integer> nodeValues = new TreeMap<Integer,Integer>();
    
    for (int i = 0; i < nodes.size(); i++){
      nodeMap.put(nodes.get(i).id, nodes.get(i).parent);
      nodeValues.put(nodes.get(i).id, nodes.get(i).weight);
      int id = nodes.get(i).id;
      while (nodeMap.get(id) != null && nodeMap.keySet().contains(nodeMap.get(id))){
        nodeValues.put(nodeMap.get(id), nodeValues.get(nodeMap.get(id)) + nodes.get(i).weight);
        id = nodeMap.get(id);
      }
    }
    
    for (int id : nodeValues.keySet())
      System.out.println(id + " " + nodeValues.get(id));
  }
  
  public static void main(String[] args){
    List<Node> nodes = new ArrayList<Node>();
    nodes.add(new Node(1, 0, 1));
    nodes.add(new Node(2, 1, 2));
    nodes.add(new Node(3, 2, 3));
    nodes.add(new Node(4, 1, 4));
    nodes.add(new Node(5, 2, 5));
    nodes.add(new Node(6, 3, 6));
    nodes.add(new Node(7, 3, 7));
    
    SumOfSubnodeValues sb = new SumOfSubnodeValues();
    sb.sumNodesInSubTrees(nodes);
  }
}
