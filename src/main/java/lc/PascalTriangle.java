package lc;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * @author lli003
 *
 */
public class PascalTriangle {
  
  public ArrayList<ArrayList<Integer>> generate(int numRows){
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (numRows < 1)
      return result;
    
    ArrayList<Integer> start = new ArrayList<Integer>();
    start.add(1);
    result.add(start);
    
    for (int i = 1; i < numRows; i++){
      ArrayList<Integer> last = result.get(i-1);
      ArrayList<Integer> newArray = new ArrayList<Integer>();
      newArray.add(1);
      for(int j = 1; j < last.size(); j++)
        newArray.add(last.get(j-1) + last.get(j));
      newArray.add(1);
      result.add(newArray);
    }
    
    return result;
  }
  
}
