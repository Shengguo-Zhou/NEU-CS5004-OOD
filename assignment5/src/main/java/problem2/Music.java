package problem2;

/**
 * Represent a Music class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Music extends Item{

  /**
   * RecordingArtist -  recordingArtist
   */
  public RecordingArtist recordingArtist;
  /**
   * Band - the band class
   */
  public Band band;

  /**
   * constructor - create a recording artist class
   * @param recordingArtist - the recording artist of the class
   */
  public Music(RecordingArtist recordingArtist) {
    this.recordingArtist = recordingArtist;
  }

  /**
   * constructor - create a band class
   * @param band - the band of music
   */
  public Music(Band band) {
    this.band = band;
  }
}
