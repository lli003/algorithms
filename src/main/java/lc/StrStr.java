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

}
