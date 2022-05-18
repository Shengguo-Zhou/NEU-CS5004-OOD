package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailTest {

  private Size size1 = new Size(2,2,0);
  private Size size2 = new Size(2,0,2);
  private Size size3 = new Size(0,2,2);
  private Size size = new Size(2,2,2);
  private Size size4 = new Size(3,3,3);
  private Recipient recipient = new Recipient("A", "B","abc@gmail.com");
  private Recipient recipient2 = new Recipient("B", "B","abc@gmail.com");
  private Mail mail = new Mail(size, recipient);
  private Mail mail2 = new Mail(size, recipient2);
  private Mail mail3 = new Mail(size4, recipient);

  @Test
  void testConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Mail(size2, recipient);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Mail(size3, recipient);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Mail(size1, recipient);
    });
  }

  @Test
  void getSize() {
    assertEquals(mail.getSize(), size);
  }

  @Test
  void getRecipient() {
    assertEquals(mail.getRecipient(), recipient);
  }

  @Test
  void testEquals() {
    assertEquals(mail, mail);
    assertNotEquals(mail, mail2);
    assertNotEquals(mail, mail3);
  }

  @Test
  void testHashCode() {
    assertEquals(mail.hashCode(), mail.hashCode());
    assertNotEquals(mail.hashCode(), mail2.hashCode());
    assertNotEquals(mail.hashCode(), mail3.hashCode());
  }
}