package basic.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * find k nearest points to the origin
 * basic idea: use a max heap to the points
 * @author leili
 *
 */
public class FindKNearestPoints {
  
  public Point[] findKNearestPoints(Point[] points, int k){
    PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new PointComparator());
    Point max = new Point(0,0);
    for (Point p : points){
      if (p.compareTo(max) > 0){
        max = p;
        if (queue.size() < k)
          queue.add(p);
      } else {
        queue.add(p);
      }
    }
    
    Point[] closest = new Point[k];
    for (int i = 0; i < k; i++){
      closest[i] = queue.remove();
    }
    
    return closest;
  }
  
  public static void main(String[] args){
    int n = 50;
    Point[] points = new Point[n];
    for (int i = n-1; i >= 0; i--){
      points[i] = new Point(i,i);
    }
    
    FindKNearestPoints fn = new FindKNearestPoints();
    Point[] res = fn.findKNearestPoints(points, 10);
    for (Point p : res)
      System.out.println(p.toString());
  }

}

class Point implements Comparable<Point>{

  private int x;
  private int y;
  
  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }
  
  public String toString(){
    return "[" + this.x + " " + this.y + "]";
  }
  
  public int distanceToOrigin(){
    return this.x * this.x + this.y * this.y;
  }
  
  public int compareTo(Point o) {
    int d1 = this.distanceToOrigin();
    int d2 = o.distanceToOrigin();
    if (d1 < d2)
      return -1;
    else if (d1 > d2)
      return 1;
    else
      return 0;
  }
  
}

class PointComparator implements Comparator<Point>{

  public int compare(Point o1, Point o2) {
    return o1.compareTo(o2);
  }
  
}
