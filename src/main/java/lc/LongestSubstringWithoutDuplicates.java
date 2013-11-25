package lc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author lli003
 *
 */
public class LongestSubstringWithoutDuplicates {
  
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0)
        return 0;
    
    int cur = 0, max = 0;
    /* record the characters seen previously. */
    Map<Character,Integer> map = new HashMap<Character,Integer>();
    
    for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if (!map.containsKey(c))
            cur++;
        else{
            Iterator<Map.Entry<Character,Integer>> iter = map.entrySet().iterator();
            // remove the character occurrence before character 'c'
            while(iter.hasNext()){
                Map.Entry<Character,Integer> entry = iter.next();
                if (entry.getValue() < map.get(c))
                    iter.remove();
            }
            // update current count
            cur = i - map.get(c);
        }
        map.put(c, i);
        max = Math.max(cur, max);
    }
    return max;
}

}
