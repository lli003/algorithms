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
  
  /* another implementation of thread-safe singleton.
   * basic idea: use a lazy holder that contains a final object.
   * when getInstance() is invoked, LazyHolder class is loaded and initialized,
   * which will result in the static variable instance being initialized. */
  private static class LazyHolder {
    private static final Singleton instance = new Singleton();
  }
  
  public static Singleton getInstance2(){
    return LazyHolder.instance;
  }

}
