package cc150.chapter09;

/**
 * Given a sorted array of strings which is interspersed with empty strings, write a method
to find the location of a given string.
Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] will return 4
Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1
 * @author lli003
 *
 */
public class SearchArrayWithEmptyEntries {
  
  public int search(String[] arr, String str){
    assert(arr != null && str != null);
    if (str.equals("")){
      for (int i = 0; i < arr.length; i++){
        if (arr[i].equals(""))
          return i;
      }
      return -1;
    }
    return search(arr, str, 0, arr.length - 1);
  }
  
  private int search(String[] arr, String str, int start, int end){
    while (start <= end){
      while (start <= end && arr[end].equals(""))
        end--;
      if (start > end)
        return -1;
      int mid = start + (end - start)/2;
      while (arr[mid].equals(""))
        mid++;
      int r = arr[mid].compareTo(str);
      if (r == 0)
        return mid;
      else if (r < 0)
        start = mid + 1;
      else
        end = mid - 1;
    }
    return -1;
  }
  
  public static void main(String[] args){
    SearchArrayWithEmptyEntries s = new SearchArrayWithEmptyEntries();
    String[] arr = {"", "a", "b", "", "", "", "d", "test", "", ""};
    String str = "a";
    System.out.println(s.search(arr, str));
  }

}
