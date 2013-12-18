package lc;

import java.util.ArrayList;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 * @author lli003
 *
 */
public class TextJustification {

  /**
   * a greedy approach
   * @param words
   * @param L
   * @return
   */
  public ArrayList<String> fullJustify(String[] words, int L) {
    ArrayList<String> res = new ArrayList<String>();
    if (words.length == 0)
      return res;

    ArrayList<String> tmp = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    int cur = 0;
    int len = 0;

    while (cur < words.length) {
      sb = new StringBuilder();
      sb.append(words[cur]);

      len = words[cur].length();
      cur++;
      tmp.clear();

      while (cur < words.length && len + 1 + words[cur].length() <= L) {
        tmp.add(" " + words[cur]);
        len += words[cur].length() + 1;
        cur++;
      }

      if (cur < words.length && tmp.size() > 0) {
        int spaces = L - len;
        int avg = spaces / tmp.size();
        int rem = spaces % tmp.size();
        for (int i = 0; i < tmp.size(); i++) {
          appendSpace(sb, i < rem ? avg + 1 : avg);
          sb.append(tmp.get(i));
        }
      } else {
        for (int i = 0; i < tmp.size(); i++)
          sb.append(tmp.get(i));
        appendSpace(sb, L - len);
      }
      res.add(sb.toString());
    }
    return res;
  }

  private void appendSpace(StringBuilder sb, int nSpace) {
    for (int i = 0; i < nSpace; i++) {
      sb.append(" ");
    }
  }

}
