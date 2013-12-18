package lc;

public class ValidNumber {
  
  public boolean isValid(String s){
    return s.matches("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$");
  }
  
  public static void main(String[] args){
    ValidNumber n = new ValidNumber();
    System.out.println(n.isValid("0"));
    System.out.println(n.isValid(" 0.1"));
    System.out.println(n.isValid("abc"));
    System.out.println(n.isValid("1 a"));
    System.out.println(n.isValid(" +2e-10"));
  }

}
