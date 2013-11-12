package cc150.chapter19;

/**
 * Write a method to shuffle a deck of cards. 
 * It must be a perfect shuffle - in other words, each 52! permutations of the deck has to be equally likely. 
 * Assume that you are given a random number generator which is perfect.
 * @author lli003
 *
 */
public class ShuffleArray {
  
  /**
   * shuffle array
   * swap the current element i with a random element after i 
   * @param array
   */
  public static void shuffleArray(int[] array){
    int temp = 0, index = 0;
    for (int i = 0; i < array.length; i++){
      index = i + (int)(Math.random() * (array.length - i));
      temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
    
    for (int i = 0; i < array.length; i++)
      System.out.print(array[i] + " ");
  }
  
  public static void main(String[] args){
    int[] array = {1,2,3,4,5,6,7,8,9,10};
    for (int i = 0; i < 10; i++){
      ShuffleArray.shuffleArray(array);
      System.out.println();
    }
  }

}
