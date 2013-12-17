package basic.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * check if a graph (represented as adjacency matrix) is a bipartite graph
 * @author leili
 *
 */
public class ValidBipartiteGraph {
  
  /**
   * bfs and color the node
   * @param G
   * @param src
   * @return
   */
  public static boolean isBipartite(int G[][], int src){
    int[] color = new int[G.length];
    for (int i = 0; i < color.length; i++){
      color[i] = -1;
    }
    
    color[src] = 1;
    Queue<Integer> visited = new LinkedList<Integer>();
    visited.offer(src);
    
    while (!visited.isEmpty()){
      int u = visited.poll();
      for (int v = 0; v < G.length; v++){
        if (G[u][v] == 1 && color[v] == -1){
          color[v] = 1 - color[u];
          visited.offer(v);
        } else if (G[u][v] == 1 && color[u] == color[v]){
          return false;
        }
      }
    }
    
    return true;
  }
  
  public static void main(String[] args){
    int G[][] = {{0, 1, 0, 1},
        {1, 0, 1, 0},
        {0, 1, 0, 1},
        {1, 0, 1, 0}
    };
 
    System.out.println(ValidBipartiteGraph.isBipartite(G, 0));
  }

}
