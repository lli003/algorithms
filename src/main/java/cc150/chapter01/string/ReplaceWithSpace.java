package cc150.chapter01.string;

/**
 * replace the space characters in a string using '%20'
 * @author leili
 *
 */
public class ReplaceWithSpace {
  
  public String replaceSpace(String s){
    assert(s != null);
    if (s.length() == 0)
      return s;
    
    int spaceCnt = 0;
    for (int i = 0; i < s.length(); i++){
      if (s.charAt(i) == ' ')
        spaceCnt++;
    }
    
    int newLength = s.length() + spaceCnt * 2;
    char[] arr = new char[newLength];
    int idx = 0;
    for (int i = 0; i < s.length(); i++){
      if (s.charAt(i) == ' '){
        arr[idx++] = '%';
        arr[idx++] = '2';
        arr[idx++] = '0';
      } else {
        arr[idx++] = s.charAt(i);
      }
    }
    return new String(arr);
  }

}
