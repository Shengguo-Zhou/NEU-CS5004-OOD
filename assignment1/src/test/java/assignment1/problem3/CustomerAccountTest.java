package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerAccountTest {
  private CustomerAccount customerAccount;
  private CustomerAccount anotherAccount;
  private Amount amount;
  private Amount anotherAmount;
  private Amount amountDeposit;
  private Amount amountWithdrawn;

  @BeforeEach
  void setUp() {
    this.amount = new Amount(12,34);
    this.anotherAmount = new Amount(14,33);
    this.amountDeposit = new Amount(1,99);
    this.amountWithdrawn = new Amount(1,99);
    this.customerAccount = new CustomerAccount("A", "B", amount);
    this.anotherAccount = new CustomerAccount("A", "B", anotherAmount);
  }

  @Test
  void depositTest() {
    Assertions.assertEquals(this.customerAccount.deposit(amountDeposit), anotherAccount);
  }

  @Test
  void withdrawTest() {
    Assertions.assertEquals(this.anotherAccount.withdraw(amountWithdrawn), customerAccount);
  }

  @Test
  void getFirstName() {
    Assertions.assertEquals(this.customerAccount.getFirstName(), "A");
  }

  @Test
  void getLastName() {
    Assertions.assertEquals(this.customerAccount.getLastName(), "B");
  }

  @Test
  void getDollar() {
    Assertions.assertEquals(this.customerAccount.getAmount(), amount);
  }

}