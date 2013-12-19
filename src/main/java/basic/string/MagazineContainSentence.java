package basic.string;

public class MagazineContainSentence {

  public boolean ransom(String sentence, String magazine) {
    int[] hash = new int[256];
    char[] mag = magazine.toCharArray();
    char[] noteArr = sentence.toCharArray();
    for (char alphabet : mag) {
      hash[alphabet]++;
    }

    for (char check : noteArr) {
      if (hash[check] <= 0) {
        return false;
      } else {
        hash[check]--;
      }
    }

    return true;
  }

}
