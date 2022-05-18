package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecipientTest {

  private Recipient recipient1 = new Recipient("a","b","abc@gmail.com");
  private Recipient recipient2 = new Recipient("a","b2","abc@gmail.com");
  private Recipient recipient3 = new Recipient("a3","b","abc@gmail.com");
  private Recipient recipient4 = new Recipient("a","b","abc3@gmail.com");

  @Test
  void constructionTest() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Recipient("a", "b",".abc.@gmail.com");
    });
  }

  @Test
  void patternMatchesTest() {
    assertEquals(recipient1.patternMatches("username.@domain.com"), false);
    assertEquals(recipient1.patternMatches(".user.name@domain.com"), false);
    assertEquals(recipient1.patternMatches("user-name@domain.com."), false);
    assertEquals(recipient1.patternMatches("username@.com"), false);
    assertEquals(recipient1.patternMatches("username@domain.com"), true);
  }

  @Test
  void getFirstName() {
    assertEquals(recipient1.getFirstName(), "a");
  }

  @Test
  void getLastName() {
    assertEquals(recipient1.getLastName(), "b");
  }

  @Test
  void getEmail() {
    assertEquals(recipient1.getEmail(), "abc@gmail.com");
  }

  @Test
  void testEquals() {
    assertNotEquals(recipient1, recipient2);
    assertNotEquals(recipient1, recipient3);
    assertNotEquals(recipient1, recipient4);
    assertEquals(recipient1, recipient1);
  }

  @Test
  void testHashCode() {
    assertNotEquals(recipient1.hashCode(), recipient2.hashCode());
    assertNotEquals(recipient1.hashCode(), recipient3.hashCode());
    assertNotEquals(recipient1.hashCode(), recipient4.hashCode());
    assertEquals(recipient1.hashCode(), recipient1.hashCode());
  }
}