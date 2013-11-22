package patterns;

public class Singleton {
  
  private static Singleton instance;
  private static int count;
  
  // private constructor
  private Singleton(){
    count = 0;
  }
  
  // static method to obtain the Singleton instance
  public static synchronized Singleton getInstance(){
    if (instance == null){
      instance = new Singleton();
    }
    return instance;
  }
  
  // static method to access the local variables
  public static synchronized int getCount(){
    return count;
  }

}
