package assignment1.problem1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehicleTest {
  private Vehicle vehicle;
  private Owner owner;
  @BeforeEach
  void setUp(){
    this.owner = new Owner("hello", "world", "1122334455");
    this.vehicle = new Vehicle(999, "AGoodVehicle", owner);
  }

  @Test
  void getVIN(){
    Assertions.assertEquals(999, this.vehicle.getVIN());
  }

  @Test
  void getLicensePlate(){
    Assertions.assertEquals("AGoodVehicle", this.vehicle.getLicensePlate());
  }

  @Test
  void getOwner(){
    Assertions.assertEquals("hello.world.1122334455", this.vehicle.getOwner());
  }


}
