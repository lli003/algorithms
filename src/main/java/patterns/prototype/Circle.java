package patterns.prototype;

public class Circle extends Shape {

  public Circle(){
    type = "circle";
  }
  
  @Override
  void draw() {
    System.out.println(type);
  }

}
