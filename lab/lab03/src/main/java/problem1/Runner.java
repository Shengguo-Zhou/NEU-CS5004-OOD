package problem1;

public class Runner extends Athlete{
  private Double best5KTime;
  private Double bestHalfMarathonTime;
  private String favouriteRunningEvent;

  public Runner(Name athletesName, Double height, Double weight, String league, double best5KTime,
      double bestHalfMarathonTime, String favouriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favouriteRunningEvent = favouriteRunningEvent;
  }

  public Runner(Name athletesName, Double height, Double weight, double best5KTime,
      double bestHalfMarathonTime, String favouriteRunningEvent) {
    super(athletesName, height, weight);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favouriteRunningEvent = favouriteRunningEvent;
  }

  public double getBest5KTime() {
    return best5KTime;
  }

  public double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  public String getFavouriteRunningEvent() {
    return favouriteRunningEvent;
  }

  public void setBest5KTime(double best5KTime) {
    this.best5KTime = best5KTime;
  }

  public void setBestHalfMarathonTime(double bestHalfMarathonTime) {
    this.bestHalfMarathonTime = bestHalfMarathonTime;
  }

  public void setFavouriteRunningEvent(String favouriteRunningEvent) {
    this.favouriteRunningEvent = favouriteRunningEvent;
  }
}
