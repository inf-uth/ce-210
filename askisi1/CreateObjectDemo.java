public class CreateObjectDemo {

  public static void main(String[] args) {

    // Declare and create a point object and two rectangle objects.
    Point originOne = new Point(23, 94);
    Rectangle rectOne = new Rectangle(originOne, 100, 200);
    Rectangle rectTwo = new Rectangle(50, 100);

    // display rectOne's origin, width, height, and area
    System.out.println("Origin of reactOne: " + rectOne.getOrigin() );
    System.out.println("Width of rectOne: " + rectOne.getWidth() );
    System.out.println("Height of rectOne: " + rectOne.getHeight() );
    System.out.println("Area of rectOne: " + rectOne.getArea());    

    // set rectTwo's position
    rectTwo.setOrigin(originOne);

    // display rectTwo's origin, width, height, and area
    System.out.println("Origin of reactTwo: " + rectTwo.getOrigin() );
    System.out.println("Width of rectTwo: " + rectTwo.getWidth() );
    System.out.println("Height of rectTwo: " + rectTwo.getHeight() );
    System.out.println("Area of rectTwo: " + rectTwo.getArea());    

    // move rectTwo and display its new position
    rectTwo.move(40, -20);
    System.out.println("Origin of reactOne: " + rectTwo.getOrigin() );
  }
}