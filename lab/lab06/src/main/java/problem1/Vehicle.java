package problem1;

import java.util.Objects;

public abstract class Vehicle implements FleetManager{
  private String ID;
  private Float speed;
  private Float maxSpeed;
  private TripReport tripReport;

  public Vehicle(String ID, Float speed, Float maxSpeed, TripReport tripReport) {
    this.ID = ID;
    this.speed = speed;
    this.maxSpeed = maxSpeed;
    this.tripReport = tripReport;
  }

  @Override
  public TripReport drive(float distance, Vehicle vehicle){
    return null;
  };

  @Override
  public int drive(float distance) {
    return 1;
  }

  @Override
  public float drive(int distance, int distance2) {
    return 2F;
  }

  @Override
  public String drive(Vehicle vehicle) {
    return "abc";
  }

}
