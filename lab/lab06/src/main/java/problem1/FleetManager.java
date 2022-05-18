package problem1;

public interface FleetManager {
  TripReport drive(float distance, Vehicle vehicle);
  int drive(float distance);
  float drive(int distance, int distance2);
  String drive(Vehicle vehicle);
}
