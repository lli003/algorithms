package advanced.dp;

/**
 * There are a row of houses, each house can be painted with three colors red, blue and green. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color. 
 * You have to paint the houses with minimum cost. How would you do it? 
 * Note: Painting house-1 with red costs different from painting house-2 with red. 
 * The costs are different for each house and each color.
 * @author leili
 *
 */
public class PaintHouseWithColors {
  
  /**
   * dp
   * the minimized result is the min value of the last column in painted array
   * @param cost
   * @return
   */
  public static int[][] paint(int[][] cost){
    int n = cost[0].length;
    int[][] painted = new int[cost.length][cost[0].length];
    for (int i = 0; i < cost.length; i++){
      painted[i][0] = cost[i][0];
    }
    
    int i = 1;
    while (i < n){
      painted[0][i] = cost[0][i] + Math.min(painted[1][i-1], painted[2][i-1]);
      painted[1][i] = cost[1][i] + Math.min(painted[0][i-1], painted[2][i-1]);
      painted[2][i] = cost[2][i] + Math.min(painted[0][i-1], painted[1][i-1]);
      i++;
    }
    
    return painted;
  }
  
  public static void main(String[] args){
//    int[][] cost = {new int[] { 7, 3, 8, 6, 1, 2},
//                    new int[] { 5, 6, 7, 2, 4, 3},
//                    new int[] {10, 1, 4, 9, 7, 6}};
    int[][] cost = {{1,4,6}, 
                    {2,100,2}, 
                    {3,100,10}};
    int[][] painted = PaintHouseWithColors.paint(cost);
    for (int i = 0; i < painted.length; i++){
      for (int j = 0; j < painted[0].length; j++){
        System.out.print(painted[i][j] + " ");
      }
      System.out.println();
    }
  }

}
