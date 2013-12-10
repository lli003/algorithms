package basic.string;

/**
 * for a given string of a sentence, reverse the words in the sentence
 * e.g.: I am a student --> student a am I
 * @author leili
 *
 */
public class ReverseSentence {
  public static String reverse(String s){
    assert(s != null);
    
    char[] res = new char[s.length()];
    int start = 0, space = -1;
    for (int i = 0; i < s.length(); i++){
      if (s.charAt(i) == ' '){
        space = i;
        /* copy a word in front of a space. */
        for (int j1 = start, j2 = s.length() - space; j1 < space; j1++, j2++){
          res[j2] = s.charAt(j1);
        }
        res[res.length - 1 - space] = ' ';
        start = space + 1;
        space = -1;
      }
    }
    
    /* reach the last word. */
    if (space == -1){
      for (int j1 = start, j2 = 0; j1 < s.length(); j1++, j2++){
        res[j2] = s.charAt(j1);
      }
    }
    
    return new String(res);
  }
  
  public static void main(String[] args){
    System.out.println(ReverseSentence.reverse("I am a student"));
    System.out.println(ReverseSentence.reverse("I"));
  }
}
