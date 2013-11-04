package lc;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example, given n = 3, there are a total of 5 unique BST's.
 * 
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 * @author lli003
 *
 */
public class UniqueBinarySearchTrees {
  
  public int numTrees(int n){
    if (n == 0 || n == 1)
      return 1;
    
    int sum = 0;
    for (int i = 0; i < n; i++){
      sum += numTrees(i) * numTrees(n - 1 - i);
    }
    
    return sum;
  }

}
