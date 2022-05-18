package problem1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public abstract class Artist{

  protected Name artistsName;
  protected Integer age;
  protected String[] genres;
  protected Award[] award;

  public Artist(Name artistsName, Integer age, String[] genres, Award[] award) {
    this.artistsName = artistsName;
    this.age = age;
    this.genres = genres;
    this.award = award;
  }

  public Name getArtistsName() {
    return artistsName;
  }

  public Integer getAge() {
    return age;
  }

  public String[] getGenres() {
    return genres;
  }

  public Award[] getAward() {
    return award;
  }

  public Boolean receiveAward(String award){
    if(award!= null) { //a more thorough checking of input string need, other information about the award needed too
      Award myAward = new Award(award, "Award category", "Award committee", LocalDate.now());
      this.award[this.award.length] = myAward;
      return Boolean.TRUE;
    }
    else return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Artist that = (Artist) o;
    return Objects.equals(artistsName, that.artistsName) && Objects.equals(age, that.age) && Arrays.equals(genres, that.genres) && Arrays.equals(award, that.award);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(artistsName, age);
    result = 31 * result + Arrays.hashCode(genres);
    result = 31 * result + Arrays.hashCode(award);
    return result;
  }

  @Override
  public String toString() {
    return "AbstractArtist{" +
        "artistsName=" + artistsName +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", award=" + Arrays.toString(award) +
        '}';
  }
}
