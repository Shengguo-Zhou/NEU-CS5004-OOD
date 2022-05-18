package problem2;

import java.util.LinkedList;

/**
 * Represent the Band class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Band extends Group{

  /**
   * name - band name
   */
  public String name;
  /**
   * member - band member
   */
  public LinkedList<RecordingArtist> member;

  /**
   * constructor - create a band constructor
   * @param name - band name
   * @param member - band member
   */
  public Band(String name, LinkedList<RecordingArtist> member) {
    this.name = name;
    this.member = member;
  }
}
