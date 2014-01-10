package basic.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * find the longest word made of other words
 * basic idea: first sort the words based on length in a desc manner
 * then for each word, try to check if it can be replaced by other words
 * @author leili
 *
 */
public class LongestWordMadeOfOtherWords {
  
  public String longestWord(String[] words){
    assert(words != null);
    
    Set<String> dict = new HashSet<String>();
    for (String w : words)
      dict.add(w);
    
    Arrays.sort(words, new LengthComparator());
    for (String w : words){
      dict.remove(w);
      if (dfs(dict, w))
        return w;
      dict.add(w);
    }
    return "";
  }
  
  private boolean dfs(Set<String> dict, String s){
    if (dict.contains(s))
      return true;
    for (int i = 1; i < s.length(); i++){
      if (dict.contains(s.substring(0,i)) && dfs(dict, s.substring(i)))
        return true;
    }
    return false;
  }
  
  public static void main(String[] args){
    String[] words = {"abcd", "dd", "cd", "a", "bc", "b", "acdeff", "eff"};
    LongestWordMadeOfOtherWords l = new LongestWordMadeOfOtherWords();
    System.out.println(l.longestWord(words));
  }

}

class LengthComparator implements Comparator<String> {
  public int compare(String s1, String s2){
    if (s1.length() < s2.length())
      return 1;
    else if (s1.length() > s2.length())
      return -1;
    else
      return 0;
  }
}
