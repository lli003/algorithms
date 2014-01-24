package cc150.chapter01.string;

import java.util.Arrays;

/**
 * determine if a string has all unique characters
 * @author leili
 *
 */
public class UniqueCharacters {
  
  /**
   * basic idea: use an additional array/hashmap to store the characters
   * @param s
   * @return
   */
  public boolean isUnique(String s){
    assert(s != null);
    if(s.length() == 0)
      return true;
    
    boolean[] dict = new boolean[256];
    for (int i  = 0; i < s.length(); i++){
      if (dict[s.charAt(i)])
        return false;
      dict[s.charAt(i)] = true;
    }
    return true;
  }
  
  /**
   * basic idea: sort the characters first, and then check one by one
   * @param s
   * @return
   */
  public boolean isUnique2(String s){
    assert(s != null);
    if(s.length() == 0)
      return true;
    
    char[] arr = s.toCharArray();
    Arrays.sort(arr);
    
    char tmp = arr[0];
    for (int i = 1; i < arr.length; i++){
      if (arr[i] == tmp)
        return false;
      tmp = arr[i];
    }
    return true;
  }
  
  /**
   * basic idea: check the characters one by one, each time from the beginning of the string
   * @param s
   * @return
   */
  public boolean isUnique3(String s){
    assert(s != null);
    if(s.length() == 0)
      return true;
    
    for (int i = 1; i < s.length(); i++){
      for (int j = 0; j < i; j++){
        if (s.charAt(i) == s.charAt(j))
          return false;
      }
    }
    return true;
  }

}
