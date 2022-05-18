package assignment1.problem2;
/**Time class contains hour, minute, second
 * ● hour, between 0 and 23, inclusive.
 * ● minutes, between 0 and 59, inclusive.
 * ● seconds, between 0 and 59 inclusive.
* */
public class Time {
  private int hour;
  private int minute;
  private int second;
  int VALID_HOUR_MIN = 0;
  int VALID_MINUTE_MIN = 0;
  int VALID_SECOND_MIN = 0;
  int VALID_HOUR_MAX = 23;
  int VALID_MINUTE_MAX = 59;
  int VALID_SECOND_MAX = 59;
  int HOUR_PER_SECOND = 3600;
  int MINUTE_PER_SECOND = 60;
  int SECOND_PER_SECOND = 1;
  int totalTime;
  /**
   * Constructor that creates a new Time object.
   * @param hour - hour.
   * @param minute - minute.
   * @param second - second.
   */
  public Time(int hour, int minute, int second){
    if(hour < VALID_HOUR_MIN || hour > VALID_HOUR_MAX ||
    minute < VALID_MINUTE_MIN || minute > VALID_MINUTE_MAX ||
    second < VALID_SECOND_MIN || second > VALID_SECOND_MAX)
      throw new IllegalArgumentException();
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    totalTime =  (hour * HOUR_PER_SECOND) +
        (minute * MINUTE_PER_SECOND) +
        (second * SECOND_PER_SECOND);
  }

  /**
   * Returns hour.
   * @return hour.
   */
  public int getHour() {
    if(hour >= VALID_HOUR_MIN && hour <= VALID_HOUR_MAX)
      return hour;
    else{
      System.out.println("not a valid hour");
      return -1;
    }

  }


  /**
   * Returns minute.
   * @return minute - minute
   */
  public int getMinute() {
    if(minute >= VALID_MINUTE_MIN && minute <= VALID_MINUTE_MAX)
      return minute;
    else{
      System.out.println("not a valid minute");
      return -1;
    }
  }

  /**
   * Returns second.
   * @return second.
   */
  public int getSecond() {
    if(second >= VALID_SECOND_MIN && second <= VALID_SECOND_MAX)
      return second;
    else{
      System.out.println("not a valid second");
      return -1;
    }
  }


  @Override
  public boolean equals(Object o) {
    if(o == this){return true;}
    if(!(o instanceof Time)){return false;}
    Time anotherTime = (Time) o;
    return Double.compare(hour, anotherTime.hour) == 0
        && Double.compare(minute, anotherTime.minute) == 0
        && Double.compare(second, anotherTime.second) == 0;
  }

}
