package problem1;

import java.util.Objects;

public class Poet extends Artist{

  private String publishingCompany;
  private String lastPublishedCollection;

  public Poet(Name artistsName, Integer age, String[] genres, Award[] award,
      String publishingCompany, String lastPublishedCollection) {
    super(artistsName, age, genres, award);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  public String getPublishingCompany() {
    return publishingCompany;
  }

  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Poet poet = (Poet) o;
    return Objects.equals(publishingCompany, poet.publishingCompany) && Objects.equals(lastPublishedCollection, poet.lastPublishedCollection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), publishingCompany, lastPublishedCollection);
  }

  @Override
  public String toString() {
    return "Poet{" +
        "publishingCompany='" + publishingCompany + '\'' +
        ", lastPublishedCollection='" + lastPublishedCollection + '\'' +
        '}';
  }
}
