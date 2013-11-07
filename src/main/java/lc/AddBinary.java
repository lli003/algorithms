package lc;

/**
 * Given two binary strings, return their sum (also a binary string).
 * @author leili
 *
 */
public class AddBinary {

  public String addBinary(String a, String b) {

    if (a.length() == 0)
      return b;
    if (b.length() == 0)
      return a;

    char[] charA = a.toCharArray();
    char[] charB = b.toCharArray();

    int lenA = charA.length - 1;
    int lenB = charB.length - 1;

    int carry = 0;
    int sum = 0;
    StringBuffer sb = new StringBuffer("");
    while (lenA >= 0 || lenB >= 0) {
      int valA = lenA >= 0 ? (charA[lenA] == '0' ? 0 : 1) : 0;
      int valB = lenB >= 0 ? (charB[lenB] == '0' ? 0 : 1) : 0;
      sum = carry + valA + valB;
      carry = sum / 2;
      sb.append(String.valueOf(sum % 2));
      lenA--;
      lenB--;
    }

    if (carry != 0)
      sb.append(String.valueOf(carry));

    return sb.reverse().toString();

  }

}
