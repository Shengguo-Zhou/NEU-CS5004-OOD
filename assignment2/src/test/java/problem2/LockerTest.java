package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LockerTest {
  private Size size1 = new Size(2,2,0);
  private Size size2 = new Size(2,0,2);
  private Size size3 = new Size(0,2,2);
  private Size size = new Size(2,2,2);
  private Size size4 = new Size(3,3,3);
  private Size size5 = new Size(4,4,4);
  private Recipient recipient = new Recipient("A", "B","abc@gmail.com");
  private Recipient recipient2 = new Recipient("B", "B","abc@gmail.com");
  private Mail mail = new Mail(size, recipient);
  private Mail mail2 = new Mail(size, recipient2);
  private Mail mail3 = new Mail(size4, recipient);
  private Mail mail4 = new Mail(size5, recipient);
  private Locker locker = new Locker(mail, size4);
  private Locker locker1 = new Locker(mail, size);
  private Locker locker2 = new Locker(mail2, size4);

  @Test
  void testConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Locker(mail, size1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Locker(mail, size2);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Locker(mail, size3);
    });
  }

  @Test
  void getMail() {
    assertEquals(locker.getMail(), null);
  }

  @Test
  void getMaxSize() {
    assertEquals(locker.getMaxSize(), size4);
  }

  @Test
  void testEquals() {
    locker.addMail(mail);
    locker1.addMail(mail);
    locker2.addMail(mail);
    assertEquals(locker, locker);
    assertNotEquals(locker, locker1);
    assertEquals(locker, locker2);
  }

  @Test
  void testHashCode() {
    locker.addMail(mail);
    locker1.addMail(mail);
    locker2.addMail(mail);
    assertEquals(locker.hashCode(), locker.hashCode());
    assertNotEquals(locker.hashCode(), locker1.hashCode());
    assertEquals(locker.hashCode(), locker2.hashCode());
  }

  @Test
  void addMail() {
    assertThrows(IllegalArgumentException.class, () ->{
      locker.addMail(mail4);
    });
    locker.addMail(mail);
    assertEquals(locker.getMail(), mail);
    assertThrows(IllegalArgumentException.class, () ->{
      locker.addMail(mail);
    });

  }

  @Test
  void pickupMail() {
    locker.addMail(mail);
    assertEquals(locker.pickupMail(recipient), mail);
    assertThrows(IllegalArgumentException.class, () ->{
      locker.pickupMail(recipient2);
    });
  }
}