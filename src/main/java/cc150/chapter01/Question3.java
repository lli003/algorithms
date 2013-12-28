package cc150.chapter01;

/**
 * remove duplicate characters in a string without using additional buffer
 * with some problems of test case "ababababa"
 * @author leili
 *
 */
public class Question3 {

  /**
   * basic idea: check the characters one by one, each time starting from the beginning of the string
   * if duplicates found, then swap the duplicate character to the end of the array
   * @param s
   * @return
   */
  public String removeDuplicates(String s){
    assert(s != null);
    if (s.length() < 2)
      return s;
    
    char[] arr = s.toCharArray();
    int l = arr.length;
    for (int i = 1; i < l;){
      for (int j = 0; j < i; j++){
        while (arr[i] == arr[j] && i < l){
          for (int k = i; k < l-1; k++){
            char tmp = arr[k];
            arr[k] = arr[k+1];
            arr[k+1] = tmp;
          }
          l--;
        }
      }
      i++;
    }
    
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < l; i++){
      sb.append(arr[i]);
    }
    return sb.toString();
  }
  
}
