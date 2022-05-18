package problem1;
public class BasketballPlayer extends Athlete{
  private String team;
  private Double averageBatting;
  private Integer seasonHomeRuns;

  public BasketballPlayer(Name athletesName, Double height, Double weight, String league,
      String team, Double averageBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  public BasketballPlayer(Name athletesName, Double height, Double weight, String team,
      Double averageBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public Double getAverageBatting() {
    return averageBatting;
  }

  public void setAverageBatting(Double averageBatting) {
    this.averageBatting = averageBatting;
  }

  public Integer getSeasonHomeRuns() {
    return seasonHomeRuns;
  }

  public void setSeasonHomeRuns(Integer seasonHomeRuns) {
    this.seasonHomeRuns = seasonHomeRuns;
  }
}
