package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class NonProfitTest {

  private LinkedList<Donation> list = new LinkedList<>();
  private LocalDateTime atime = LocalDateTime.of(2018, Month.MARCH,10,22,10,30);
  private LocalDateTime btime = LocalDateTime.of(2022, Month.MARCH,10,22,10,30);
  private LocalDateTime ctime = LocalDateTime.of(2035, Month.MARCH,10,22,10,30);
  private OneTimeDonation oneTimeDonation = new OneTimeDonation(1.11, atime);
  private MonthlyDonation monthlyDonation1 = new MonthlyDonation(2.22, atime);
  private MonthlyDonation monthlyDonation2 = new MonthlyDonation(2.22, btime);
  private MonthlyDonation monthlyDonation3 = new MonthlyDonation(2.22, atime);
  private MonthlyDonation monthlyDonation4 = new MonthlyDonation(3.33, atime);
  private Pledge pledge1 = new Pledge(3.33, atime);
  private Pledge pledge2 = new Pledge(3.33);
  private NonProfit nonProfit = new NonProfit("abc", list);

  @Test
  void setMonthlyDonation() throws InvalidDonationTime, InvalidCancellationTime {
    assertThrows(InvalidCancellationTime.class, () ->{
      monthlyDonation2.setCancellationTime(atime);
    });
    assertThrows(InvalidDonationTime.class, () ->{
      pledge2.setDonationTime(atime);
    });
    pledge1.removeDonationTime();
    pledge1.setDonationTime(ctime);
    monthlyDonation2.setCancellationTime(ctime);
  }

  @Test
  void addDonation() {
    nonProfit.addDonation(oneTimeDonation);
    nonProfit.addDonation(monthlyDonation1);
    nonProfit.addDonation(monthlyDonation2);
    nonProfit.addDonation(pledge1);
    nonProfit.addDonation(pledge2);
  }

  @Test
  void getTotalDonationsForYear() throws InvalidCancellationTime {
    nonProfit.addDonation(oneTimeDonation);
    nonProfit.addDonation(monthlyDonation1);
    nonProfit.addDonation(monthlyDonation2);
    nonProfit.addDonation(pledge1);
    nonProfit.addDonation(pledge2);
    assertEquals(nonProfit.getTotalDonationsForYear(2018), 26.64);
    assertEquals(nonProfit.getTotalDonationsForYear(2019), 26.64);
    assertEquals(nonProfit.getTotalDonationsForYear(2022), 48.84);
    assertEquals(nonProfit.getTotalDonationsForYear(2023), 53.28);
    nonProfit.addDonation(monthlyDonation3);
    monthlyDonation2.setCancellationTime(ctime);
    assertEquals(nonProfit.getTotalDonationsForYear(2023), 79.92);
    assertEquals(nonProfit.getTotalDonationsForYear(2022), 75.48);
    monthlyDonation1.setCancellationTime(btime);
    assertEquals(nonProfit.getTotalDonationsForYear(2022), 55.5);
    assertEquals(nonProfit.getTotalDonationsForYear(2023), 53.28);
  }

  @Test
  void equalTest() {
    assertEquals(nonProfit, nonProfit);
    assertEquals(oneTimeDonation, oneTimeDonation);
    assertNotEquals(oneTimeDonation, nonProfit);
    assertNotEquals(nonProfit, "abc");
    assertNotEquals(oneTimeDonation, monthlyDonation1);
    assertNotEquals(monthlyDonation4, monthlyDonation1);
    assertNotEquals(monthlyDonation2, monthlyDonation1);
    assertNotEquals(monthlyDonation2, monthlyDonation3);
    assertEquals(nonProfit.hashCode(), nonProfit.hashCode());
    assertEquals(oneTimeDonation.hashCode(), oneTimeDonation.hashCode());
    assertNotEquals(oneTimeDonation.hashCode(), nonProfit.hashCode());
    assertNotEquals(oneTimeDonation.hashCode(), monthlyDonation1.hashCode());
    assertNotEquals(monthlyDonation2.hashCode(), monthlyDonation3.hashCode());
    nonProfit.addDonation(oneTimeDonation);
    NonProfit nonProfit2 = new NonProfit("abc", list);
    NonProfit nonProfit3 = new NonProfit("bc", list);
    assertEquals(nonProfit2, nonProfit);
    assertNotEquals(nonProfit2, nonProfit3);
  }
}