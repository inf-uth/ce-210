public class RunBike {
  public static void main(String args[]) {
    Bicycle myBicycle = new Bicycle(10, 20, 30);
    MountainBike myBike = new MountainBike(11,22,33, 45);
    MountainBike yourBike = new MountainBike(myBicycle, 35);
    
    System.out.println("[myBicycle] "+myBicycle);
    System.out.println("[myBike]    "+myBike);
    System.out.println("[yourBike]  "+yourBike);
  }
}