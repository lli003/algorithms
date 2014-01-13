package lc;

/**
 * Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * @author leili
 *
 */
public class StrStr {

  public String strStr(String haystack, String needle) {
    if (haystack == null || needle == null
        || haystack.length() < needle.length())
      return null;

    int l = needle.length();
    for (int i = 0; i <= haystack.length() - l; i++) {
      boolean find = true;
      int j = 0;
      while (j < l) {
        if (needle.charAt(j) != haystack.charAt(j + i)) {
          find = false;
          break;
        }
        j++;
      }
      if (find)
        return haystack.substring(i);
    }
    return null;

  }
  
  public String strStr2(String haystack, String needle){
    if (haystack == null || needle == null || haystack.length() < needle.length())
      return null;
    
    if (needle.length() == 0)
      return haystack;
    if (needle.length() == 1){
      boolean find = false;
      for (int i = 0; i < haystack.length(); i++){
        if (haystack.charAt(i) == needle.charAt(0))
          return haystack.substring(i);
      }
      if (!find)
        return null;
    }
    
    // construct KMP table
    int[] table = new int[needle.length()];
    table[0] = -1;
    table[1] = 0;
    int pos = 2, cnd = 0;
    while (pos < needle.length()){
      if (needle.charAt(pos-1) == needle.charAt(cnd)){
        cnd++;
        table[pos] = cnd;
        pos++;
      } else if (cnd > 0){
        cnd = table[cnd];
      } else {
        table[pos] = 0;
        pos++;
      }
    }
    
    int m = 0, i = 0;
    while (m + i < haystack.length()){
      if (haystack.charAt(m+i) == needle.charAt(i)){
        if (i == needle.length() - 1)
          return haystack.substring(m);
        i++;
      } else {
        m = m + i - table[i];
        if (table[i] > - 1)
          i = table[i];
        else
          i = 0;
      }
    }
    return null;
  }

}
