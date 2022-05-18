package assignment1.problem3;

/**
 * CustomerAccount consists of
 ● The account holder’s name.
 * An account holder is an individual with a first and last name.
 */

public class CustomerAccount {
  private String firstName;
  private String lastName;
  private Amount amount;

  /**
   * CustomerAccount
   * @param firstName - first name.
   * @param lastName - last name.
   * @param amount - dollar and cents
   */
  public CustomerAccount(String firstName, String lastName, Amount amount) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.amount = amount;
  }

  /**
   * Returns first name.
   * @return firstName.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns last name.
   * @return lastName.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns amount - amount of money.
   * @return amount - amount of money.
   */
  public Amount getAmount() {
    return amount;
  }

  /**
   * override comparator
   */
  @Override
  public boolean equals(Object o) {
    if(o == this) { return true;}
    if(!(o instanceof CustomerAccount)) { return false;}
    CustomerAccount anotherAccount = (CustomerAccount) o;
    return firstName == anotherAccount.firstName &&
        lastName == anotherAccount.lastName &&
        amount.equals(anotherAccount.amount);
  }

  /**
   * Returns a new CustomerAccount object.
   * @param anotherAmount - the amount of money.
   * @return a CustomerAccount with a new balance.
   */
  public CustomerAccount deposit(Amount anotherAmount) {
    String firstName = this.firstName;
    String lastName = this.lastName;

    double CENTS_TO_DOLLAR = 100;
    double totalMoney = (double) this.amount.getDollar() +
        (double) this.amount.getCents() / CENTS_TO_DOLLAR +
        (double) anotherAmount.getDollar() +
        (double) anotherAmount.getCents() / CENTS_TO_DOLLAR;

    int totalDollar = (int) totalMoney;
    int totalCents = (int) ((totalMoney - totalDollar) * CENTS_TO_DOLLAR);

    Amount newAmount = new Amount(totalDollar, totalCents);
    return new CustomerAccount(firstName, lastName, newAmount);
  }

  /**
   * Returns a new CustomerAccount object.
   * @param anotherAmount - the amount of money withdrawn.
   * @return a CustomerAccount with a new balance.
   */
  public CustomerAccount withdraw(Amount anotherAmount) {
    String firstName = this.firstName;
    String lastName = this.lastName;
    double CENTS_TO_DOLLAR = 100;
    double totalMoney = (double) this.amount.getDollar() +
        (double) this.amount.getCents() / CENTS_TO_DOLLAR -
        (double) anotherAmount.getDollar() -
        (double) anotherAmount.getCents() / CENTS_TO_DOLLAR;

    int totalDollar = (int) totalMoney;
    int totalCents = (int) Math.ceil((totalMoney - totalDollar) * CENTS_TO_DOLLAR);

    Amount newAmount = new Amount(totalDollar, totalCents);
    return new CustomerAccount(firstName, lastName, newAmount);
  }

}
