package lc;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * @author leili
 *
 */
public class CountAndSay {

  public String countAndSay(int n) {
    String start = "1";

    for (int i = 1; i < n; i++) {
      char[] as = start.toCharArray();
      int j = 0;
      int count = 1;
      char cur = ' ';
      StringBuffer sb = new StringBuffer("");
      while (j < as.length) {
        cur = as[j];
        while (j < as.length - 1 && as[j] == as[j + 1]) {
          count++;
          j++;
        }
        sb.append(count);
        sb.append(String.valueOf(cur));
        count = 1;
        j++;
      }
      start = sb.toString();
    }

    return start;
  }

}
