package problem1;

public class Information {
  protected String firstName;
  protected String lastName;
  protected String address;
  protected String city;
  protected String state;
  protected String zip;
  protected String email;

  public Information(){}

  public void getInformation(String line){
    String[] eachLine = line.split(",");
    int len = eachLine.length;
    this.firstName = eachLine[0].substring(1, eachLine[0].length() - 1);
    // should have a check, if there is a ',' in the last name, for emample "jack, smith"
    // eachLine[1] would be " "jack ", eachLine would be " smith" "
    // character ' " ' is 34
    if((int) eachLine[1].charAt(1) == 34) {
      StringBuilder stringBuilder = new StringBuilder(eachLine[1].substring(2, eachLine[1].length() - 1));
      stringBuilder.append(new StringBuilder(eachLine[2].substring(2, eachLine[1].length() - 2)));
      this.lastName = stringBuilder.toString();
    }
    else this.lastName = eachLine[1].substring(1, eachLine[1].length() - 1);

    this.email = eachLine[len - 2].substring(1, eachLine[len - 2].length() - 1);
    this.zip = eachLine[len - 5].substring(1, eachLine[len - 5].length() - 1);
    this.state = eachLine[len - 6].substring(1, eachLine[len - 6].length() - 1);
    this.city = eachLine[len - 8].substring(1, eachLine[len - 8].length() - 1);
    this.address = eachLine[len - 9].substring(1, eachLine[len - 9].length() - 1);
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getCity() {
    return this.city;
  }

  public String getState() {
    return this.state;
  }

  public String getZip() {
    return this.zip;
  }

  public String getEmail() {
    return this.email;
  }

  public String getAddress(){
    return this.address;
  }
}
