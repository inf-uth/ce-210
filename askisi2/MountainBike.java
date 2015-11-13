public class MountainBike extends Bicycle {

  private int seatHeight;

  // the MountainBike subclass has
  // one constructor
  public MountainBike(int startCadence,
            int startSpeed, int startGear, int startHeight) {
    super(startCadence, startSpeed, startGear);
    seatHeight = startHeight;
  }
  
  public MountainBike(Bicycle bicycle, int startHeight) {
    super(bicycle.getCadence(), bicycle.getSpeed(), bicycle.getGear());
    seatHeight = startHeight;
  }
    
  // the MountainBike subclass has
  // one method
  public void setHeight(int newValue) {
    seatHeight = newValue;
  }
  
  public int getSeatHeight() {
    return seatHeight;
  }
  
  public String toString() {
     return super.toString() + ", Seat Height: "+seatHeight;
  }
}