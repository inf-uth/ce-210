public class Bicycle {
    
  private int cadence;
  private int gear;
  private int speed;
     
  public Bicycle(int startCadence, int startSpeed, int startGear) {
    gear = startGear;
    cadence = startCadence;
    speed = startSpeed;
  }
  
  public int getCadence() {
      return cadence;
  }
  
  public int getGear() {
      return gear;
  }
  
  public int getSpeed() {
      return speed;
  }

  public void setCadence(int newValue) {
    cadence = newValue;
  }
    
  public void setGear(int newValue) {
    gear = newValue;
  }
  
  public void setSpeed(int newSpeed) {
	speed = newSpeed;
  }
    
  public void applyBrake(int decrement) {
    speed -= decrement;
  }
    
  public void speedUp(int increment) {
    speed += increment;
  }
  
  public String toString() {
     return "Gear: "+gear+", Cadence: "+cadence+", Speed: "+speed;
  }   
}