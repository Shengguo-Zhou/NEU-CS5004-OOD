package problem2;

public class Civilian extends Pieces{

  public Integer wealth;

  public Civilian(String name, Integer age, Integer wealth) {
    super(name, age);
    this.wealth = wealth;
  }

  public void addCurrent(int money){
    this.wealth += money;
  }

  public void reduceCurrent(int money){
    this.wealth -= money;
  }
}
