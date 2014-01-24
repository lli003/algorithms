package cc150.chapter01.string;

/**
 * reverse a C-style string
 * @author leili
 *
 */
public class ReverseString {
  
  public String reverse(String s){
    assert(s != null);
    
    int start = 0, end = s.length() - 1;
    char[] arr = s.toCharArray();
    
    while (start < end){
      char tmp = arr[start];
      arr[start] = arr[end];
      arr[end] = tmp;
      start++;
      end--;
    }
    
    return new String(arr);
  }
  
}
