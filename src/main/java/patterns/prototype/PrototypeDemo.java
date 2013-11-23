package patterns.prototype;

public class PrototypeDemo {
  
  public static void main(String[] args){
    ShapeCache.loadShapeCache();
    
    Shape circle = (Shape) ShapeCache.getShape("1");
    System.out.println(circle.getType());
    
    Shape square = (Shape) ShapeCache.getShape("2");
    System.out.println(square.getType());
  }

}
