package assignment1.problem1;
/**
 * a vehicle typically has an owner. An owner has:
● A first name, typically represented as a String.
● A last name, also represented as a String.
● A phone number, a String, consisting of ten characters1.
*/
public class Owner {
  private String firstName;
  private String lastName;
  private String phoneNumber;
  int PHONE_NUMBER_LENGTH = 10;
  String DEFAULT_NUMBER = "-1";

  /**
  * Constructor creates a new Owner object with specified
  * firstName, lastName and phoneNumber
  * @param firstName - firstName
  * @param lastName - lastName
  * @param phoneNumber - phoneNumber
  * */
  public Owner(String firstName, String lastName, String phoneNumber){
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  /**
   * Returns the firstName.
   * @return the firstName.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Returns the lastName.
   * @return the lastName.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Returns the phoneNumber.
   * @return the phoneNumber.
   */
  public String getPhoneNumber() {
    if(phoneNumber.length() != PHONE_NUMBER_LENGTH) return "Not a valid phone number";
    return this.phoneNumber;
  }

}
