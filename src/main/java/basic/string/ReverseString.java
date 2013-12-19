package basic.string;

public class ReverseString {
  
  /**
   * recursive solution
   * @param s
   * @return
   */
  public String reverse(String s){
    if (s.length() == 0)
      return "";
    
    return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
  }
  
  public String reverse2(String s){
    if (s.length() == 0)
      return s;
    
    char[] arr = s.toCharArray();
    
    int left = 0, right = arr.length - 1;
    while (left < right){
      char tmp = arr[left];
      arr[left] = arr[right];
      arr[right] = tmp;
      left++;
      right--;
    }
    
    return new String(arr);
  }
  
  public static void main(String[] args){
    ReverseString rs = new ReverseString();
    String s = "This is a test";
    System.out.println(rs.reverse(s));
    System.out.println(rs.reverse2(s));
  }

}
