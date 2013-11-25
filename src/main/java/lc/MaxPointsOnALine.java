package lc;

import lc.util.Point;

public class MaxPointsOnALine {
  
  /**
  *  find the maximum number of points in a line. 
  */
  public int maxPoints(Point[] points){
      if (points == null)
          return 0;
      if (points.length < 2 || allSame(points))
          return points.length;
      
      int maxCount = 2;
      for (int i = 0; i < points.length; i++){
          for (int j = i+1; j < points.length; j++){
              if ((points[i].x == points[j].x) && (points[i].y == points[j].y))
                  continue;
              int count = 2;
              for (int k = 0; k < points.length; k++){
                  if (k != i && k!= j && sameLine(points[i], points[j], points[k]))
                      count++;
              }
              maxCount = Math.max(maxCount, count);
          }
      }
      return maxCount;
  }
  
  /** 
  * check if three points are in the same line.
  * Basic idea: check if the slopes of (a,b) and (b,c) are the same
  * slope(a,b) = (a.y - b.y)/(a.x - b.x), slope(b,c) = (b.y - c.y)/(b.x - c.x)
  * to avoid 0 division, multiply them to be (a.y-b.y)*(b.x-c.x) = (b.y-c.y)*(a.x-b.x)
  */
  private boolean sameLine(Point a, Point b, Point c){
      return (a.y-b.y)*(b.x-c.x) == (b.y-c.y)*(a.x-b.x);
  }
  
  /**
  * check if all the points are the same
  */
  private boolean allSame(Point[] points){
      int x = points[0].x;
      int y = points[0].y;
      for (int i = 1; i < points.length; i++){
          if ((x != points[i].x) || (y != points[i].y))
              return false;
      }
      return true;
  }

}
