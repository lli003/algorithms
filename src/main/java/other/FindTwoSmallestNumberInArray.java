package other;

public class FindTwoSmallestNumberInArray {

  public static int[] findTwoSmallestNumber(int[] array) {
    if (array == null || array.length < 2)
      return null;

    int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    for (int i = 0; i < array.length; i++) {
      if (array[i] < min) {
        min2 = min;
        min = array[i];
      } else if (array[i] < min2 && array[i] != min) {
        min2 = array[i];
      }
    }

    int[] result = new int[2];
    result[0] = min;
    result[1] = min2;
    return result;
  }
  
  public static void main(String[] args){
    int[] array = {3,1,2,2,54,6,7,34,1,3,2};
    int[] result = FindTwoSmallestNumberInArray.findTwoSmallestNumber(array);
    System.out.printf("The minimum number: %d\nThe second minimum number: %d", result[0], result[1]);
  }

}
