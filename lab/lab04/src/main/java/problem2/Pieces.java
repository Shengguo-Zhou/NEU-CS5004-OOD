package problem2;

import java.util.Objects;

public class Pieces {

  private String name;
  private Integer age;

  public Pieces(String name, Integer age) {
    this.name = name;
    if(age >= 0 && age <= 128)
      this.age = age;
    else
      throw new IllegalArgumentException("age is not valid");
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getAge());
  }
}
