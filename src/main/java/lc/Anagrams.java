package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 * @author leili
 *
 */
public class Anagrams {
  
  public ArrayList<String> anagrams(String[] strs){
    ArrayList<String> result = new ArrayList<String>();
    if (strs.length == 0)
        return result;
    
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    for (int i = 0; i < strs.length; i++){
        char[] chars = strs[i].toCharArray();
        Arrays.sort(chars);
        String newStr = new String(chars);
        if (map.containsKey(newStr)){
            map.get(newStr).add(strs[i]);
        } else {
            ArrayList<String> list = new ArrayList<String>();
            list.add(strs[i]);
            map.put(newStr, list);
        }
    }
    for (String s : map.keySet()){
        if(map.get(s).size() > 1)
            result.addAll(map.get(s));
    }
    return result;
  }

}
