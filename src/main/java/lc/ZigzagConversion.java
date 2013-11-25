package lc;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author lli003
 *
 */
public class ZigzagConversion {
  
  public String convert(String s, int nRows){
    assert(s != null);
    /* if nRows <= 1, then do not convert the string at all. */
    if (nRows <= 1)
        return s;
    
    StringBuffer sb = new StringBuffer();
    int diff = nRows + nRows - 2; // difference of two columns
    for (int i = 0; i < nRows; i++){
        int index = i;
        while (index < s.length()){
            sb.append(s.charAt(index));
            index += diff;
            /* append the intermediate characters between two full columns. */
            if (i != 0 && i != nRows - 1 && index - i - i < s.length())
                sb.append(s.charAt(index));
        }
    }
    return sb.toString();
  }

}
