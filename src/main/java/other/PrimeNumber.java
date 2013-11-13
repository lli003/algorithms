package other;

public class PrimeNumber {

  public void printPrimeNum(int num) {
    boolean[] flags = new boolean[num + 1];
    for (int i = 2; i < flags.length; i++)
      flags[i] = true;

    for (int i = 2; i < Math.sqrt(num); i++) {
      if (flags[i]) {
        for (int j = i; j * i <= num; j++)
          flags[i * j] = false;
      }
    }
    System.out.println("The primes are: ");
    for (int i = 0; i < flags.length; i++) {
      if (flags[i] == true)
        System.out.print(" " + i + " ");
    }
  }
  
  public static void main(String[] args){
    PrimeNumber pn = new PrimeNumber();
    pn.printPrimeNum(100);
  }

}
