package assignment1.problem2;
/**For each commuter trip made by an employee,
 * you will need to store the trip’s starting location (a String),
 * the end location (a String), and the start and end time.
 * */
public class Trip {
  private String startLoc;
  private String endLoc;
  private Time startTime;
  private Time endTime;
  /**
   * Constructor that creates a new  object.
   * @param startLoc - start location.
   * @param endLoc - end location.
   * @param startTime - start time.
   * @param endTime - end time;
   */
  Trip(String startLoc, String endLoc, Time startTime, Time endTime){
    this.startLoc = startLoc;
    this.endLoc = endLoc;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Returns start location.
   * @return start location.
   */
  public String getStartLocation() {
    return startLoc;
  }


  /**
   * Returns end location.
   * @return end location.
   */
  public String getEndLocation() {
    return endLoc;
  }

  /**
   * Returns start time.
   * @return startTime - start time.
   */
  public String getStartTime() {
    return startTime.getHour() + ":" +
        startTime.getMinute() + ":" +
        startTime.getSecond();
  }

  /**
   * Returns end time.
   * @return endTime - end time.
   */
  public String getEndTime() {
    return endTime.getHour() + ":" +
        endTime.getMinute() + ":" +
        endTime.getSecond();
  }

  /**
   * Returns the Time of duration.
   * @return a duration Time.
   */
  public Time getDuration() {
    int totalSecond = endTime.totalTime - startTime.totalTime;
    int durTimeHour = totalSecond / endTime.HOUR_PER_SECOND;
    int durTimeMinute = totalSecond % endTime.HOUR_PER_SECOND / endTime.MINUTE_PER_SECOND;
    int durTimeSecond = totalSecond % endTime.HOUR_PER_SECOND % endTime.MINUTE_PER_SECOND;

    return new Time(durTimeHour, durTimeMinute, durTimeSecond);
  }

}
