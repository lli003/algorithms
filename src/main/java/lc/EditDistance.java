package lc;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 * @author leili
 *
 */
public class EditDistance {

  public int minDistance(String word1, String word2) {
    if (word2.length() == 0)
      return word1.length();

    int[][] d = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++)
      d[i][0] = i;
    for (int i = 0; i <= word2.length(); i++)
      d[0][i] = i;

    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1))
          d[i][j] = d[i - 1][j - 1];
        else
          d[i][j] = Math.min(d[i - 1][j - 1],
              Math.min(d[i - 1][j], d[i][j - 1])) + 1;
      }
    }
    return d[word1.length()][word2.length()];
  }

}
