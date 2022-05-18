package problem2;

public class Soldier extends Pieces{

  public Integer stamina;

  public Soldier(String name, Integer age, Integer stamina) {
    super(name, age);
    if(stamina >= 0 && stamina <= 100)
      this.stamina = stamina;
    else
      throw new IllegalArgumentException("stamina is not valid");
  }

  public void add(int energy){
    stamina += energy;
  }
  public void reduce(int energy){
    stamina -= energy;
  }

}
