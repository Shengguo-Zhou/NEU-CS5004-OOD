package assignment1.problem3;

/**
 *  ● The current account balance as an amount. An amount consists of:
 *  ○ An integer value for the US dollar amount, greater than or equal to 0.
 *  ○ An integer value for the US cents amount, between 0 and 99 inclusive.
 */
public class Amount {
  private int dollar;
  private int cents;
  private int MIN_DOLLAR = 0;
  private int MIN_CENTS = 0;
  private int MAX_CENTS = 99;
  /**
   * CustomerAccount
   * @param dollar - dollar.
   * @param cents - cents.
   */
  public Amount(int dollar, int cents) {
    this.dollar = dollar;
    this.cents = cents;
  }
  /**
   * Returns dollar - dollar.
   * @return dollar.
   */
  public int getDollar() {
    if(dollar < MIN_DOLLAR){
      System.out.println("Not a valid dollar number");
      return MIN_DOLLAR;
    }
    return this.dollar;
  }
  /**
   * Returns cents - cents.
   * @return cents - cents.
   */
  public int getCents() {
    if(cents < MIN_CENTS || cents > MAX_CENTS){
      System.out.println("Not a valid dollar cents");
      return MIN_CENTS;
    }
    return this.cents;
  }

  /**
   * override comparator
   */
  @Override
  public boolean equals(Object o) {
    if(o == this) { return true;}
    if(!(o instanceof Amount)) { return false;}
    Amount anotherAmount = (Amount) o;
    return dollar == anotherAmount.dollar &&
        cents == anotherAmount.cents;
  }
}
