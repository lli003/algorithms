package patterns.factory;

public class ShapeFactory {
  
  public Shape generateShape(String shapeType){
    if (shapeType.equals(""))
      return null;
    
    if (shapeType.equals("circle"))
      return new Circle();
    else if (shapeType.equals("square"))
      return new Square();
    return null;
  }

}
