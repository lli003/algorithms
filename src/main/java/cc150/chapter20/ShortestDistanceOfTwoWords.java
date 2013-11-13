package cc150.chapter20;

/**
 * You have a large text file containing words. Given any two words, find the
 * shortest distance (in terms of number of words) between them in the file. Can
 * you make the searching operation in O(1) time? What about the space
 * complexity for your solution?
 * 
 * @author lli003
 * 
 */
public class ShortestDistanceOfTwoWords {

  // assume the words are stored in an array
  public int searchWords(String[] words, String word1, String word2) {
    if (words == null || words.length < 2 || word1.equals(word2))
      return 0;
    int pos = 0;
    int min = Integer.MAX_VALUE/2;
    int posWord1 = Integer.MIN_VALUE/2;
    int posWord2 = Integer.MIN_VALUE/2;

    // scan the word array to find the postions of two words
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        posWord1 = pos;
        // without considering the order of two words
        int dist = posWord1 - posWord2;
        if (min > dist)
          min = dist;
      } else if (words[i].equals(word2)) {
        posWord2 = pos;
        int dist = posWord2 - posWord1;
        if (min > dist)
          min = dist;
      }
      pos++;
    }
    return min;
  }

}
