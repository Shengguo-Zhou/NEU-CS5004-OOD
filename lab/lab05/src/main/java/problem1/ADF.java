package problem1;

import java.util.Arrays;

public abstract class ADF extends Artist{

  protected String[] movies;
  protected String[] series;
  protected String[] otherMultimedia;

  public ADF(Name artistsName, Integer age, String[] genres,
      Award[] award, String[] movies, String[] series, String[] otherMultimedia) {
    super(artistsName, age, genres, award);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  public String[] getMovies() {
    return movies;
  }

  public String[] getSeries() {
    return series;
  }

  public String[] getOtherMultimedia() {
    return otherMultimedia;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    ADF that = (ADF) o;
    return Arrays.equals(movies, that.movies) && Arrays.equals(series, that.series) && Arrays.equals(otherMultimedia, that.otherMultimedia);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(movies);
    result = 31 * result + Arrays.hashCode(series);
    result = 31 * result + Arrays.hashCode(otherMultimedia);
    return result;
  }

  @Override
  public String toString() {
    return "MediaArtists{" +
        "movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", otherMultimedia=" + Arrays.toString(otherMultimedia) +
        '}';
  }
}
