public class Rectangle {
  private int width, height;
  
  public Rectangle(int w, int h) {
    width = w;
    height = h;
  }
   
  public void setHeight(int h) {
     height = h;
  }
  
  public void setWidth(int w) {
     width = w;
  }
    
  public int getHeight() {
     return height;
  }
  
  public int getWidth() {
     return width;
  }
  
  public String toString() {
    return "height: "+height+", width: "+width;
  }
}