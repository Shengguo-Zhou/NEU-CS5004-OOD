package problem1;

import java.util.Objects;

public class Musician extends Artist{

  private String recordingCompany;
  private String lastRecordedAlbum;

  public Musician(Name artistsName, Integer age, String[] genres, Award[] award,
      String recordingCompany, String lastRecordedAlbum) {
    super(artistsName, age, genres, award);
    this.recordingCompany = recordingCompany;
    this.lastRecordedAlbum = lastRecordedAlbum;
  }

  public String getRecordingCompany() {
    return recordingCompany;
  }

  public String getLastRecordedAlbum() {
    return lastRecordedAlbum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Musician musician = (Musician) o;
    return Objects.equals(recordingCompany, musician.recordingCompany) && Objects.equals(lastRecordedAlbum, musician.lastRecordedAlbum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), recordingCompany, lastRecordedAlbum);
  }

  @Override
  public String
  toString() {
    return "Musician{" +
        "recordingCompany='" + recordingCompany + '\'' +
        ", lastRecordedAlbum='" + lastRecordedAlbum + '\'' +
        '}';
  }
}