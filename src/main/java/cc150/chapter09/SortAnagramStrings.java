package cc150.chapter09;

import java.util.Arrays;
import java.util.Comparator;

public class SortAnagramStrings {

  public static String[] sortAnagrams(String[] strs) {

    Comparator<String> comparator = new Comparator<String>() {

      private String sortString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
      }
      
      public int compare(String s1, String s2) {
        return sortString(s1).compareTo(sortString(s2));
      }
    };
    
    Arrays.sort(strs, comparator);
    return strs;
  }
  
  public static void main(String[] args){
    String[] strs = {"test", "tset", "ttes", "abc", "acb", "abt", "tes"};
    strs = SortAnagramStrings.sortAnagrams(strs);
    for (String s : strs)
      System.out.println(s);
  }

}
