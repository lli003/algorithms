package patterns.factory;

public class FactoryDemo {
  
  public static void main(String[] args){
    ShapeFactory sf = new ShapeFactory();
    Shape circle = sf.generateShape("circle");
    circle.draw();
    Shape square = sf.generateShape("square");
    square.draw();
  }

}
