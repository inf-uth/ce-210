public class FinestComparator {

    public StrictlyComparable findLarger(StrictlyComparable obj1, StrictlyComparable obj2) {
        if ((obj1).isLarger(obj2) > 0)
            return obj1;
        else 
            return obj2;
    }
    
    public StrictlyComparable findSmaller(StrictlyComparable obj1, StrictlyComparable obj2) {
        if ((obj1).isLarger(obj2) < 0)
            return obj1;
        else 
            return obj2;
    }
    
    public boolean isEqual(StrictlyComparable obj1, StrictlyComparable obj2) {
        if ( (obj1).isLarger(obj2) == 0)
            return true;   
        else
            return false;
    }
    
    public static void main(String args[]) {
        Point p = new Point(10,20);
        Rectangle rec1 = new Rectangle(p, 30, 40);
        Rectangle rec2 = new Rectangle(p, 30, 40);
        FinestComparator comp = new FinestComparator();
    
        System.out.println("rec1 is "+rec1.toString());
        System.out.println("rec2 is "+rec2.toString());
    
        if( !comp.isEqual(rec1,rec2) ) {
            System.out.println( comp.findLarger(rec1, rec2).toString()+"  is larger!");
            System.out.println( comp.findSmaller(rec1, rec2).toString()+"  is smaller!");
        } else {
            System.out.println("Objects are equal!");
        }
    }
}