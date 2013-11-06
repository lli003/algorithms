package lc;

/**
 * Given an integer, convert it to a roman numeral.
 * @author leili
 *
 */
class IntegerToRoman {
  
  public String intToRoman(int num){
    int[] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    StringBuffer sb = new StringBuffer("");
    
    for (int i = 0; i < integers.length; i++){
      int times = num / integers[i];
      num -= times * integers[i];
      for (int j = 0; j < times; j++)
        sb.append(symbols[i]);
    }
    
    return sb.toString();
  }

}
