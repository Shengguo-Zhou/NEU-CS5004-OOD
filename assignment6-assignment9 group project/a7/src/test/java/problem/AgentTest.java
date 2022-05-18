package problem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgentTest {

  private Sale sale1, sale2, sale3, sale4;
  private Rental rental1, rental2, rental3, rental4;
  private Residential r1, r2, r3, r4, r5;
  private Commercial c1, c2, c3, c4;
  private Listing<Property, Contract> l1, l2, l3, l4, l5, l6;
  private ArrayList<Listing<Property, Contract>> list1, list2, list3;
  private Agent<Property, Contract> a1, a2, a3, a4, a5, a6;

  @BeforeEach
  void setUp() {
    sale1 = new Sale(123.4, true);
    sale2 = new Sale(123.5, true);
    sale3 = new Sale(123.4, false);
    sale4 = new Sale(1000.0, false);
    rental1 = new Rental(123.4, true, 1);
    rental2 = new Rental(123.5, true, 1);
    rental3 = new Rental(123.4, false, 1);
    rental4 = new Rental(123.4, true, 2);
    r1 = new Residential("a", 1, 1, 1.0);
    r2 = new Residential("b", 1, 1, 1.0);
    r3 = new Residential("a", 10, 1, 1.5);
    r4 = new Residential("a", 1, 10, 1.0);
    r5 = new Residential("aaa", 100, 2, 2.5);
    r5.setAddress("a");
    r5.setSize(10);
    r5.setNumOfBedroom(1);
    r5.setNumOfBathroom(1.5);
    c1 = new Commercial("a", 1, 1, true);
    c2 = new Commercial("b", 1, 1, true);
    c3 = new Commercial("a", 1, 10, true);
    c4 = new Commercial("a", 1, 1, false);
    l1 = new Listing<>(r1, sale1);
    l2 = new Listing<>(c1, rental1);
    l3 = new Listing<>(r1, sale2);
    l4 = new Listing<>(r4, sale1);
    l5 = new Listing<>(r4, sale1);
    l6 = new Listing<>(r4, rental4);
    list1 = new ArrayList<>();
    list2 = new ArrayList<>();
    list1.add(l1);
    list2.add(l1);
    list2.add(l2);

    a1 = new Agent<>("aa", list1, 0.2, 10.0);
    a2 = new Agent<>("bb", list1, 0.2, 10.0);
    a3 = new Agent<>("aa", list2, 0.2, 10.0);
    a4 = new Agent<>("aa", list1, 0.3, 10.0);
    a5 = new Agent<>("aaa", list1, 0.5, 10.0);
    a4.setCommissionRate(0.2);
    a5.setName("aa");
    a5.setTotalEarning(11.0);
    a5.setCommissionRate(0.1);
    a5.setCommissionRate(0.3);

    list3 = new ArrayList<>();
    list3.add(l6);
    a6 = new Agent<>("a6", list3, 0.2, 0.0);
  }

  @Test
  void agent() {
    a1.addListing(l1);
    a1.dropListing(l1);
    a1.completeListing(l1);
    a1.getCommissionRate();
    a1.getListings();
    a1.getName();
    a1.getTotalEarning();
    a1.getTotalPortfolioValue();
    a1.toString();
    a2.addListing(l1);
    a2.dropListing(l1);
    a2.getCommissionRate();
    a2.getListings();
    a2.getName();
    a2.getTotalEarning();
    a2.getTotalPortfolioValue();
    a3.getTotalPortfolioValue();
    l1.toString();
    l1.getProperty();
    r1.toString();
    rental1.toString();

  }

  @Test
  void testToString() {
    assertEquals(sale1.toString(), "Sale{askingPrice=123.4, priceIsNegotiable=true}");
  }

  @Test
  void get() {
    rental1.setTerm(1);
    assertEquals(1, rental1.getTerm());
    assertEquals(12.34, rental1.calculateCommission(0.10), 0.00001);
    rental1.getAskingPrice();
    rental1.getPriceIsNegotiable();
    rental1.setAskingPrice(126.6);
    rental1.setPriceIsNegotiable(false);
    Assertions.assertEquals(123.4 * 2 * 0.2, a6.getTotalPortfolioValue());
    Assertions.assertEquals(123.4 * 0.2, a4.getTotalPortfolioValue());
    r1.getNumOfBathroom();
    r1.getNumOfBedroom();
    r1.getSize();
    r1.getAddress();
    c1.toString();
    c1.setNumOfOffice(3);
    c1.setSuitableForRetail(false);
    c1.getNumOfOffice();
    c1.getSuitableForRetail();

    assertThrows(IllegalArgumentException.class, () -> {
      new Commercial("abc", 0, -1, true);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      c1.setAddress("");
    });

    assertThrows(IllegalArgumentException.class, () -> {
      c1.setSize(-10);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      c1.setNumOfOffice(-1);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      sale2.calculateCommission(-0.2);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      a2.setCommissionRate(1.2);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      a2.setName("");
    });

    assertThrows(IllegalArgumentException.class, () -> {
      a2.setTotalEarning(-1.0);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      rental1.calculateCommission(1.2);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      rental1.setTerm(-1);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      new Rental(1.2, true, -1);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      new Residential("a", -1, 1, 1.11);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      new Residential("a", 1, -1, 1.11);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      new Residential("a", 1, 1, -1.11);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      new Agent<>("a", list1, -0.9, 10.0);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      new Agent<>("a", list1, 10.9, 10.0);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      new Agent<>("", list1, 10.9, 10.0);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      a2.dropListing(l2);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      a2.completeListing(l2);
    });
  }

  @Test
  void testEquals() {
    assertEquals(sale1, sale1);
    assertNotEquals(sale1, sale2);
    assertNotEquals(sale1, sale3);
    assertFalse(sale1.equals("123"));
    assertEquals(rental1, rental1);
    assertNotEquals(rental1, rental2);
    assertNotEquals(rental1, rental3);
    assertNotEquals(rental1, rental4);
    assertFalse(rental1.equals("rental1"));
    assertNotEquals(l1, l3);
    assertNotEquals(l1, l4);
    assertEquals(r1, r1);
    assertEquals(r3, r5);
    assertNotEquals(r1, r2);
    assertFalse(r1.equals(c2));
    assertNotEquals(r1, r3);
    assertNotEquals(r1, r4);
    assertNotEquals(r1, r5);
    assertFalse(r1.equals("123"));
    assertEquals(c1, c1);
    assertFalse(c1.equals(r1));
    assertEquals(c1, c2);
    assertFalse(c1.equals("123"));
    assertNotEquals(c1, c3);
    assertNotEquals(c1, c4);
    assertNotEquals(c1, null);
    assertEquals(l1, l1);
    assertEquals(l4, l5);
    assertNotEquals(l1, l2);
    assertNotEquals(l1, null);
    assertFalse(l1.equals("123"));
    assertEquals(a1, a1);
    assertNotEquals(a1, a2);
    assertNotEquals(a1, a3);
    assertEquals(a1, a4);
    assertNotEquals(a1, a5);
    assertFalse(a1.equals("123"));

  }

  @Test
  void testHashCode() {
    assertEquals(sale1.hashCode(), sale1.hashCode());
    assertNotEquals(sale1.hashCode(), sale2.hashCode());
    assertNotEquals(sale1.hashCode(), sale3.hashCode());
    assertNotEquals(sale1.hashCode(), "123".hashCode());
    assertEquals(rental1.hashCode(), rental1.hashCode());
    assertNotEquals(rental1.hashCode(), rental2.hashCode());
    assertNotEquals(rental1.hashCode(), rental3.hashCode());
    assertNotEquals(rental1.hashCode(), "rental1".hashCode());
    assertEquals(r1.hashCode(), r1.hashCode());
    assertNotEquals(r1.hashCode(), r2.hashCode());
    assertNotEquals(r1.hashCode(), r3.hashCode());
    assertNotEquals(r1.hashCode(), r4.hashCode());
    assertNotEquals(r1.hashCode(), r5.hashCode());
    assertNotEquals(r1.hashCode(), "123".hashCode());
    assertEquals(c1.hashCode(), c1.hashCode());
    assertEquals(c1.hashCode(), c2.hashCode());
    assertEquals(l1.hashCode(), l1.hashCode());
    assertEquals(a1.hashCode(), a1.hashCode());
    assertNotEquals(c1.hashCode(), r1.hashCode());
  }
}