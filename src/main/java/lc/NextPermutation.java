package lc;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * @author leili
 *
 */
public class NextPermutation {
  
  /**
   * basic idea:
   * search from the right-end of the permutation to find the first pair where left < right
   * swap these two values
   * reverse the list right to the left point
   */
   public void nextPermutation(int[] num){
       if (num.length < 2)
           return;
       int l = num.length - 2;
       int r = num.length - 1;
       while (num[l] >= num[r]){
           if (l + 1 == r){
               l--;
               r = num.length - 1;
               if (l < 0)
                   break;
           } else{
               r--;
           }
       }
       if (l >= 0)
           swap(num, l, r);
       reverse(num, l+1, num.length - 1);
       return;
   }
   
   private void swap(int[] num, int i, int j){
       int temp = num[i];
       num[i] = num[j];
       num[j] = temp;
   }
   
   private void reverse(int[] num, int i, int j){
       while (i < j){
           swap(num, i, j);
           i++;
           j--;
       }
   }

}
