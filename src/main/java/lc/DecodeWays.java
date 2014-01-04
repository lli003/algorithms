package lc;

public class DecodeWays {

  public int numDecodes(String s) {
    assert (s != null);
    if (s.length() == 0)
      return 0;

    /* one-dimensional dp. */
    int[] count = new int[s.length() + 1];

    /* initialization. */
    count[0] = 1;

    /*
     * fill in the rest entries based on the idea: count[i] = count[i-1] +
     * count[i-2] if s.substring(0,i-1) is valid and s.substring(0,i-2) is valid
     */
    for (int i = 1; i <= s.length(); i++) {
      int c1 = 0;
      if (s.charAt(i - 1) != '0')
        c1 = count[i - 1];
      int c2 = 0;
      if (i >= 2
          && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2'
              && s.charAt(i - 1) <= '6')))
        c2 = count[i - 2];
      count[i] = c1 + c2;
    }
    return count[s.length()];
  }

}
