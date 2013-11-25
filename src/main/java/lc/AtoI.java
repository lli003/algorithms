package lc;

/**
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * @author lli003
 *
 */
public class AtoI {
  
  public int atoi(String str){
    assert(str != null);
    
    /* flags to indicate space, + and - */
    boolean pos = false, neg = false;
    
    /* indices to record the start and end point of number characters. */
    int istart = 0, iend = str.length() - 1;
    
    /* go through the str to obtain the + or - flag, and the number sequence. */
    for (int i = 0; i < str.length(); i++){
        if (str.charAt(i) == ' '){
            if (pos || neg) return 0;
        } else if (str.charAt(i) == '+'){
            if (pos || neg) return 0;
            pos = true;
        } else if (str.charAt(i) == '-'){
            if (pos || neg) return 0;
            neg = true;
        } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            istart = i; // start index
            /* go through left characters until reaching a non-number character. */
            while (i < str.length()){
                if (str.charAt(i) < '0' || str.charAt(i) > '9')
                    break;
                i++;
            }
            iend = i - 1;
            break;
        } else
            return 0;
    }
    
    /* get the number sequence. */
    int size = iend-istart+1;
    char[] numbers = str.substring(istart, iend+1).toCharArray();
    
    /* calculate the number. */
    long temp = 0;
    for (int i = size - 1; i >= 0; i--)
        temp += Integer.valueOf(String.valueOf(numbers[i])) * Math.pow(10, size - i - 1);
    
    if (neg){
        if (temp > Integer.MAX_VALUE)
            return Integer.MIN_VALUE;
        return (0 - (int)temp);
    }
    if (temp > Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
    return (int)temp;
  }

}
