public class BoxUsage {
   public static void main(String args[]) {
     Box b = new Box();
     Integer n = new Integer(5);
     b.set(n);
     String s = (String)b.get();
   }
}