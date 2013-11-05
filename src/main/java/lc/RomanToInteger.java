package lc;

/**
 * Given a roman numeral, convert it to an integer.
 * @author lli003
 *
 */
public class RomanToInteger {
  
  public int romanToInt(String s){
    char[] arr = s.toCharArray();
    int result = 0;
    int l = arr.length - 1;
    while (l >= 0){
      if (l-1 >= 0 && (getNumber(arr[l]) > getNumber(arr[l-1]))){
        result += getNumber(arr[l]) - getNumber(arr[l-1]);
        l -= 2;
      } else {
        result += getNumber(arr[l]);
        l--;
      }
    }
    return result;
  }
  
  private int getNumber(char c){
    switch(c){
      case 'I' : return 1;
      case 'V' : return 5;
      case 'X' : return 10;
      case 'L' : return 50;
      case 'C' : return 100;
      case 'D' : return 500;
      case 'M' : return 1000;
    }
    return 0;
  }

}
