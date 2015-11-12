public class Rectangle {
  private int width, height;
  private Point origin;
  
  public Rectangle(Point p, int w, int h) {
    origin = p;
    width = w;
    height = h;
  }
  
  public Rectangle(int x, int y, int w, int h) {
    origin = new Point(x,y);
    width = w;
    height = h;
  }
  
  public Rectangle(int w, int h) {
    this(0, 0, w, h);
  }
  
  public void setOrigin(Point p) {
    origin = p;
  }
  
  public void setHeight(int h) {
     height = h;
  }
  
  public void setWidth(int w) {
     width = w;
  }
  
  public Point getOrigin() {
     return origin;
  }
  
  public int getHeight() {
     return height;
  }
  
  public int getWidth() {
     return width;
  }
  
  public int getArea() {
     return width * height;
  }
  
  // Move rectangle origin by x,y
  public void move(int x, int y) {
     origin.setX( origin.getX() + x );
     origin.setY( origin.getY() + y );
  }
  
  public String toString() {
    String str = "height: "+height+", width: "+width+", area: "+getArea();
    return origin.toString() + str;
  }
}