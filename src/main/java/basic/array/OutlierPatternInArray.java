package basic.array;

/**
 * Give an array of integers, which are in repeated format except one integer, write a function to return that integer.
 * For example,  [2,2,3,3,4,4,4,5,5] = 4,   [2,2,2,3,3,3,3,4,4,4] = 3
 * @author lli003
 *
 */
public class OutlierPatternInArray {
  
  public int findOutlier(int[] A){
    int count1 = 0, count2 = 0, count3 = 0, patternCount = -1;
    
    int l = A.length;
    int i = 0;
    while (i < l - 1 && A[i] == A[i+1])
      i++;
    count1 = i+1;
    
    i++;
    while (i < l - 1 && A[i] == A[i+1])
      i++;
    count2 = i + 1 - count1;
    
    if (count1 != count2){
      i++;
      while (i < l - 1 && A[i] == A[i+1])
        i++;
      count3 = i + 1 - count1 - count2;
      
      if (count1 == count3)
        return A[count1];
      if (count2 == count3)
        return A[0];
    }
    
    patternCount = count1;
    i++;
    
    while (i < l){
      if (i + patternCount - 1 > l)
        return A[i];
      if (A[i] != A[i + patternCount - 1])
        return A[i];
      if (A[i] == A[i + patternCount])
        return A[i];
      i += patternCount;
    }
    
    return -1;
  }

}
