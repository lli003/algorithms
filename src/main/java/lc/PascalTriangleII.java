package lc;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * @author lli003
 *
 */
public class PascalTriangleII {
  
  /**
   * intial solution without considering space requirement
   * @param rowIndex
   * @return
   */
  public ArrayList<Integer> getRow(int rowIndex){
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (rowIndex < 0)
      return result;
    if (rowIndex == 0){
      result.add(1);
      return result;
    }
    
    result.add(1);
    for (int i = 1; i <= rowIndex; i++){
      ArrayList<Integer> newList = new ArrayList<Integer>();
      newList.add(1);
      for (int j = 1; j < result.size(); j++){
        newList.add(result.get(j) + result.get(j-1));
      }
      newList.add(1);
      result = new ArrayList<Integer>(newList);
    }
    
    return result;
  }

}
