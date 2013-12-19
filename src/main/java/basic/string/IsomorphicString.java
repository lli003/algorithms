package basic.string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given two (dictionary) words as Strings, determine if they are isomorphic. Two words are called isomorphic 
if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all 
occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters 
may map to the same letter, but a letter may map to itself. 

Example: 
given "foo", "app"; returns true 
we can map 'f' -> 'a' and 'o' -> 'p' 
given "bar", "foo"; returns false 
we can't map both 'a' and 'r' to 'o' 

given "turtle", "tletur"; returns true 
we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r' 

given "ab", "ca"; returns true 
we can map 'a' -> 'c', 'b' -> 'a'
 * @author lli003
 *
 */
public class IsomorphicString {
  
  public boolean isIsomorphic(String a, String b){
    assert(a != null && b != null);
    
    if (a.length() != b.length())
      return false;
    
    if (a.length() == 0 && b.length() == 0)
      return true;
    
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    for (int i = 0; i < a.length(); i++){
      if (map.containsKey(a.charAt(i))){
        if (b.charAt(i) != map.get(a.charAt(i)))
          return false;
      } else {
        ArrayList<Character> list = new ArrayList<Character>(map.values());
        if (list.contains(b.charAt(i)))
          return false;
        map.put(a.charAt(i), b.charAt(i));
      }
    }
    
    return true;
  }
  
  public static void main(String[] args){
    IsomorphicString is = new IsomorphicString();
    System.out.println(is.isIsomorphic("abca", "zbxz"));
    System.out.println(is.isIsomorphic("turtle", "tletur"));
    System.out.println(is.isIsomorphic("bar", "foo"));
    System.out.println(is.isIsomorphic("ab", "ca"));
    
//    String[] arr = { "cacccdaabc", "cdcccaddbc", "dcdddbccad", "bdbbbaddcb",
//        "bdbcadbbdc", "abaadcbbda", "babcdabbac", "cacdbaccad",
//        "dcddabccad", "cacccbaadb", "bbcdcbcbdd", "bcbadcbbca" };
    String[] arr = {"aa", "ab", "bb", "cc", "cd"};
    int count = 0;
    for (int i = 0; i < arr.length; i++){
      for (int j = i + 1; j < arr.length; j++){
        if (is.isIsomorphic(arr[i], arr[j]))
          count++;
      }
    }
    System.out.println(count);
  }

}
