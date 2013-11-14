package lc;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * @author leili
 *
 */
public class PalindromePartitioningII {
  
  /**
   * the combination of one-dimension dp and two-dimension dp
   * 
   * one-dimension dp: dp[i] = 1 + dp[j+1] i<=j<s.length()
   * two-dimension dp: check if s.substring(i,j) is a palindrome
   * open a two-dimension array to record such information
   * s.substring(i,j) is a palindrome if s[i] == s[j] && par[i+1][j-1] is true
   * @param s
   * @return
   */
  public int minCut(String s){
    int l = s.length();
    int[] dp = new int[l+1];
    for (int i = 0; i <= l; i++)
        dp[i] = l-i;
    
    boolean[][] par = new boolean[l][l];
    
    for (int i = l-1; i >= 0; i--){
        for (int j = i; j < l; j++){
            if (s.charAt(i) == s.charAt(j) && (j-i < 2 || par[i+1][j-1])){
                par[i][j] = true;
                dp[i] = Math.min(dp[i], dp[j+1]+1);
            }
        }
    }
    return dp[0] - 1;
  }

}
