package advanced.recursion;

import java.util.ArrayList;

/**
 * Print all possible strings of length k that can be formed from a set of n characters
 * the character duplicate is allowed
 * @author lli003
 *
 */
public class CombinationStrings {
  
  public ArrayList<String> combinations(char[] set, int k){
    assert(set != null && k > 0);
    ArrayList<String> result = new ArrayList<String>();
    lengthKStrings(set, "", result, set.length, k);
    return result;
  }
  
  private void lengthKStrings(char[] set, String pre, ArrayList<String> result, int n, int k){
    if (k == 0){
      result.add(pre);
      return;
    }
    
    for (int i = 0; i < n; i++){
      String newPre = pre + set[i];
      lengthKStrings(set, newPre, result, n, k-1);
    }
  }
  
  public static void main(String[] args){
    char[] set = {'a', 'b'};
    int k = 3;
    
    CombinationStrings cs = new CombinationStrings();
    ArrayList<String> res = cs.combinations(set, k);
    for (String s : res)
      System.out.println(s);
  }

}
