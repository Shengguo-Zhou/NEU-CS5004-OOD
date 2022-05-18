package assignment1.problem1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnerTest {
  private Owner owner;

  @BeforeEach
  void setUp(){
    this.owner = new Owner("hello","world","0123456789");
  }

  @Test
  void getFirstName(){
    Assertions.assertEquals("hello", this.owner.getFirstName());
  }
  @Test
  void getLastName(){
    Assertions.assertEquals("world", this.owner.getLastName());
  }
  @Test
  void getPhoneNumber(){
    Assertions.assertEquals("0123456789", this.owner.getPhoneNumber());
  }
}

