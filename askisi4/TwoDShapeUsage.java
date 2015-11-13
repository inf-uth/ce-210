public class TwoDShapeUsage {
  public static void main(String [] args) {
    Rectangle rect = new Rectangle(10,20);
    TwoDShape<Rectangle> shape1 = new TwoDShape<Rectangle>(rect, "Rectangle(10x20)");
    Circle circle = new Circle(10);
    TwoDShape<Circle> shape2 = new TwoDShape<Circle>(circle, "Circle(radius 10)");
    System.out.println("shape1 is "+ shape1.toString());
    System.out.println("shape2 is "+ shape2.toString());
  }
}