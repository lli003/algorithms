package lc;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * @author leili
 *
 */
public class RestoreIPAddress {

  /**
   * bfs
   * @param s
   * @return
   */
  public ArrayList<String> restoreIpAddresses(String s) {
    ArrayList<String> result = new ArrayList<String>();
    if (s.length() > 12)
      return result;
    helper(s, 0, "", result);
    return result;
  }

  private void helper(String seg, int level, String tmp,
      ArrayList<String> result) {
    if (level == 4) {
      if (seg.length() == 0) {
        result.add(tmp.substring(1));
        return;
      }
    }

    int len = seg.length() >= 3 ? 3 : seg.length();
    for (int i = 1; i <= len; i++) {
      String newS = seg.substring(0, i);
      if (isValid(newS)) {
        tmp += "." + newS;
        helper(seg.substring(i), level + 1, tmp, result);
        tmp = tmp.substring(0, tmp.lastIndexOf("."));
      }
    }
  }

  private boolean isValid(String s) {
    if (s.charAt(0) == '0')
      return s.length() == 1;
    int n = Integer.valueOf(s);
    if (n > 255)
      return false;
    return true;
  }
  
  public static void main(String[] args){
    RestoreIPAddress r = new RestoreIPAddress();
    ArrayList<String> list = r.restoreIpAddresses("2525511135");
    for (String s : list)
      System.out.println(s);
  }

}
