package lc;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 * @author leili
 *
 */
public class DistinctSubsequence {

  public int numDistinct(String S, String T) {
    if (S == null || T == null || S.length() < T.length())
      return 0;

    int[] result = new int[T.length() + 1];
    result[0] = 1;
    for (int i = 0; i < S.length(); i++) {
      for (int j = T.length() - 1; j >= 0; j--) {
        if (S.charAt(i) == T.charAt(j) && result[j] > 0) {
          result[j + 1] += result[j];
        }
      }
    }
    return result[result.length - 1];
  }

}
