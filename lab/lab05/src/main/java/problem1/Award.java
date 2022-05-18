package problem1;

import java.time.LocalDate;
import java.util.Objects;

public class Award {

  private String awardName;
  private String awardCategory;
  private String awardCommittee;
  private LocalDate dateOfTheAward;

  public Award(String awardName, String awardCategory,
      String awardCommittee, LocalDate dateOfTheAward) {
    this.awardName = awardName;
    this.awardCategory = awardCategory;
    this.awardCommittee = awardCommittee;
    this.dateOfTheAward = dateOfTheAward;
  }

  public String getAwardName() {
    return awardName;
  }

  public String getAwardCategory() {
    return awardCategory;
  }

  public String getAwardCommittee() {
    return awardCommittee;
  }

  public LocalDate getDateOfTheAward() {
    return dateOfTheAward;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Award award = (Award) o;
    return Objects.equals(awardName, award.awardName) && Objects.equals(awardCategory, award.awardCategory) && Objects.equals(awardCommittee, award.awardCommittee) && Objects.equals(dateOfTheAward, award.dateOfTheAward);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awardName, awardCategory, awardCommittee, dateOfTheAward);
  }

  @Override
  public String toString() {
    return "Award{" +
        "awardName='" + awardName + '\'' +
        ", awardCategory='" + awardCategory + '\'' +
        ", awardCommittee='" + awardCommittee + '\'' +
        ", dateOfTheAward=" + dateOfTheAward +
        '}';
  }
}