package problem1and2;

import java.util.Objects;

/**
 * This is an immutable BagOfWords class.
 * The BagOfWords class is a linked list of Element objects. Each Element object has a string and a
 * priority property. The priority property is the hashcode of the string.
 *
 */
public class BagOfWords {

  /**
   * Using Element store string data, the priority property is the hashcode of the word.
   */
  private Element first;

  /**
   * Declaring a private instance variable `rest` that is a BagOfWords.
   */
  private BagOfWords rest;

  /**
   * Constructor for empty BagOfWords
   */
  public BagOfWords() {
  }

  /**
   * Overloaded constructor for BagOfWords
   * @param first - first element of the BagOfWords, Element class
   * @param rest - rest of the BagOfWords, BagOfWords class
   */
  public BagOfWords(Element first, BagOfWords rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Get the first element of the BagOfWords
   * @return first element, Element class
   */
  public Element getFirst() {
    return this.first;
  }

  /**
   * Get the rest elements of the BagOfWords
   * @return rest elements, BagOfWords class
   */
  public BagOfWords getRest() {
    return this.rest;
  }

  /**
   * Return an empty BagOfWords
   * @return an empty BagOfWords
   */
  public BagOfWords emptyBagOfWords() {
    return new BagOfWords();
  }

  /**
   * Check whether the BagOfWords is empty
   * @return True if the first element is null else False, boolean
   */
  public Boolean isEmpty() {
    return this.first == null;
  }

  /**
   * Get the size of the BagOfWords
   * @return the size of BagOfWords, integer
   */
  public Integer size() {
    if (this.first == null) {
      return 0;
    }
    if (this.rest == null) {
      return 1;
    }
    return 1 + this.rest.size();
  }

  /**
   * Help function to get the string hash code
   * @param s - given string, string
   * @return string hashcode, integer
   */
  public int getStringHashCode(String s) {
    return Objects.hash(s);
  }

  /**
   * Returns a new BagOfWords that contains all elements
   * in the original BagOfWords plus s.
   * @param s - given string, string
   * @return a new BagOfWords that contains all elements
   * in the original BagOfWords plus s.
   */
  public BagOfWords add(String s) {
    int sCode = this.getStringHashCode(s);
    Element newWord = new Element(sCode, s);
    if (this.first == null) {
      return new BagOfWords(newWord, null);
    }
    if (sCode <= this.first.getPriority()) {
      return new BagOfWords(newWord, this);
    } else if (this.rest == null) {
      return new BagOfWords(this.first, new BagOfWords(newWord, null));
    } else {
      return new BagOfWords(this.first, this.rest.add(s));
    }
  }

  /**
   * Checks if s is in the BagOfWords. Returns true if
   * the BagOfWords contains s and false otherwise.
   * @param s - given s wanted to be checked, string
   * @return true if the BagOfWords contains s and false otherwise.
   */
  public Boolean contains(String s) {
    if (this.first == null || (!this.first.getValue().equals(s) && this.rest == null)) {
      return false;
    }
    if (this.first.getValue().equals(s)) {
      return true;
    }
    return this.rest.contains(s);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return first + ", " + rest;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BagOfWords)) {
      return false;
    }
    BagOfWords that = (BagOfWords) o;
    return Objects.equals(first, that.first) && Objects.equals(rest, that.rest);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(first, rest);
  }
}
