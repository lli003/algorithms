package basic.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import lc.util.UndirectedGraphNode;

public class RouteBetweenTwoNodes {

  public enum State{
    Unvisited, Visited, Visiting;
  }
  
  public boolean search(UndirectedGraphNode[] graph, UndirectedGraphNode start,
      UndirectedGraphNode end) {
    assert(start != null && end != null);
    
    Map<UndirectedGraphNode, State> map = new HashMap<UndirectedGraphNode,State>();
    for (UndirectedGraphNode node : graph)
      map.put(node, State.Unvisited);
    
    Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    queue.add(start);
    while (!queue.isEmpty()){
      UndirectedGraphNode node = queue.poll();
      if (node != null){
        for (UndirectedGraphNode neighbor : node.neighbors){
          if (map.get(neighbor) == State.Unvisited){
            if (neighbor == end)
              return true;
            else{
              map.put(neighbor, State.Visiting);
              queue.offer(neighbor);
            }
          }
        }
        map.put(node, State.Visited);
      }
    }
    return false;
  }

}
