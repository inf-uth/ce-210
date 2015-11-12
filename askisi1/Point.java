public class Point {
  private int xCoord, yCoord;
   
  public Point(int x, int y) {
    xCoord = x;
    yCoord = y;
  }
  public void setX(int x) {
    xCoord = x;
  }
  public void setY(int y) {
    yCoord = y;
  }
  public int getX() {
    return xCoord;
  }
  public int getY() {
    return yCoord;
  }
  public String toString() {
    return "xCoord: "+xCoord+", yCoord: "+yCoord;
  }
}