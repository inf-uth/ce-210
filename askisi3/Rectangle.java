public class Rectangle 
    implements StrictlyComparable {
    public int width = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    public Rectangle() {
        origin = new Point(0, 0);
    }
    public Rectangle(Point p) {
        origin = p;
    }
    public Rectangle(int w, int h) {
        origin = new Point(0, 0);
        width = w;
        height = h;
    }
    public Rectangle(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.setX(x);
        origin.setY(y);
    }

    // a method for computing
    // the area of the rectangle
    public int getArea() {
        return width * height;
    }
    
    // a method required to implement
    // the Relatable interface
    public int isLarger(StrictlyComparable other) {
        Rectangle otherRect = (Rectangle)other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;               
    }
    
    public static void main(String args[]) {
	Point p = new Point(10,20);
	Rectangle rec1 = new Rectangle(p, 30, 40);
	Rectangle rec2 = new Rectangle(p, 30, 20);
	if( rec1.isLarger(rec2) > 0 ) {
		System.out.println("rec1 is larger!");
	}
	else if( rec1.isLarger(rec2) < 0 ) {
		System.out.println("rec2 is larger!");
	}
	else {
		System.out.println("req1 is equal to req2");
	}
		
    }
}