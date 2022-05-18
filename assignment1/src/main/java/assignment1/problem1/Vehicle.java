package assignment1.problem1;
/**
 * Vehicle is a simple object that has a unique Vehicle Identification Number (VIN), and corresponding license plate.
 */
public class Vehicle {
  private Integer VIN;
  private String licensePlate;
  private Owner owner;
  /**
   * Constructor that creates a new vehicle object with the specified VIN
   and
   * license plate.
   * @param VIN - VIN of the new Vehicle object.
   * @param licensePlate - license plate of the new Vehicle.
   * @param owner - owner of the vehicle
   */
  public Vehicle(Integer VIN, String licensePlate, Owner owner) {
    this.VIN = VIN;
    this.licensePlate = licensePlate;
    this.owner = owner;
  }
  /**
   * Returns the VIN of the Vehicle.
   * @return the VIN of the Vehicle.
   */
  public Integer getVIN() {
    return this.VIN;
  }
  /**
   * Returns the licensePlate of the Vehicle.
   * @return the licensePlate of the Vehicle.
   */
  public String getLicensePlate() {
    return this.licensePlate;
  }

  /**
   * Return the owner firstname, lastname, and phonenumber.
   * @return the owner firstname, lastname, and phonenumber.
   */
  public String getOwner(){
    return this.owner.getFirstName() + "." +
        this.owner.getLastName() + "." +
        this.owner.getPhoneNumber();
  }
}

