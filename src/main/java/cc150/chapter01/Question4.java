package cc150.chapter01;

import java.util.Arrays;

/**
 * decide if two strings are anagrams or not
 * @author leili
 *
 */
public class Question4 {

  /**
   * basic idea: sort the characters of each string, and then check one by one
   * @param a
   * @param b
   * @return
   */
  public boolean isAnagram(String a, String b){
    assert(a != null && b != null);
    if (a.length() != b.length())
      return false;
    
    char[] arrA = a.toCharArray();
    char[] arrB = b.toCharArray();
    Arrays.sort(arrA);
    Arrays.sort(arrB);
    for (int i = 0; i < arrA.length; i++){
      if (arrA[i] != arrB[i])
        return false;
    }
    return true;
  }
  
}
