package lc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 * @author lli003
 *
 */
public class SubstringWithConcatenationOfAllWords {

  public ArrayList<Integer> findSubstring(String S, String[] L) {
    assert(S != null && L != null);
    
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (S.length() == 0 || L.length == 0)
        return result;
    
    int l = L[0].length();
    int total = l * L.length;
    if (S.length() < total)
        return result;
    
    HashMap<String,Integer> countMap = new HashMap<String,Integer>();
    for (String str : L){
        if (countMap.containsKey(str)){
            countMap.put(str, countMap.get(str) + 1);
        } else {
            countMap.put(str, 1);
        }
    }
    
    for (int i = 0; i <= S.length() - total; i++){
        HashMap<String,Integer> map = new HashMap<String,Integer>(countMap);
        int count = 0;
        int j = i;
        while (count < L.length){
            String key = S.substring(j,j+l);
            if (map.containsKey(key)){
                if (map.get(key) == 1)
                    map.remove(key);
                else
                    map.put(key, map.get(key) - 1);
                count++;
                j += l;
            }else
                break;
        }
        if (count != L.length)
            continue;
        if (map.isEmpty())
            result.add(i);
    }
    
    return result;
  }

}
