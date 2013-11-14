package lc;

import java.util.HashMap;
import java.util.LinkedList;

import lc.util.UndirectedGraphNode;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * @author leili
 *
 */
public class CloneGraph {
  
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
    if (node == null)
        return node;
    
    HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    UndirectedGraphNode start = new UndirectedGraphNode(node.label);
    map.put(node, start);
    
    // use queue to store the nodes previous accessed
    LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    queue.offer(node);
    
    // use breadth-first search to scan the graph nodes
    while (!queue.isEmpty()){
      UndirectedGraphNode head = queue.poll();
      for (UndirectedGraphNode neighbor : head.neighbors){
        if (map.containsKey(neighbor)){
          map.get(head).neighbors.add(map.get(neighbor));
        } else {
          UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
          map.put(neighbor, copy);
          map.get(head).neighbors.add(copy);
          queue.offer(neighbor);
        }
      }
    }
    
    return start;
  }

}
