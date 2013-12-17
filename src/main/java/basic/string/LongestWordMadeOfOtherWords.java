package basic.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * find the longest word made of other words
 * basic idea: first sort the words based on length in a desc manner
 * then for each word, try to check if it can be replaced by other words
 * 
 * Potential issue: not work after replacing a long word while the original word can be made of shorter words
 * @author leili
 *
 */
public class LongestWordMadeOfOtherWords {
  
  public String longestWord(String[] words){
    assert(words != null);
    
    Arrays.sort(words, new LengthComparator());
    for (String word : words){
      String backup = new String(word);
      for (String other : words){
        if (!other.equals(backup) && word.contains(other))
          word.replace(other, "");
      }
      if (word.length() == 0)
        return backup;
    }
    return null;
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
