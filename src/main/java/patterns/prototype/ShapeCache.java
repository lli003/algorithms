package patterns.prototype;

import java.util.HashMap;

public class ShapeCache {
  
  private static HashMap<String, Shape> shapeMap = new HashMap<String, Shape>();
  
  public static Shape getShape(String id){
    Shape shape = shapeMap.get(id);
    return (Shape) shape.clone();
  }
  
  public static void loadShapeCache(){
    Circle circle = new Circle();
    circle.setId("1");
    shapeMap.put(circle.getId(), circle);
    
    Square square = new Square();
    square.setId("2");
    shapeMap.put(square.getId(), square);
  }

}
