package problem2;

import java.util.Objects;

/**
 * Represent the set class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Set {

  /**
   * DEFAULTLENGTH - length of course.
   */
  private final int DEFAULTLENGTH = 10;
  /**
   * array - the array in the set
   */
  public int[] array;
  /**
   * array - the array in the set
   */
  public int[] array2;
  /**
   * index - the index of the set
   */
  private final int LING = 0;
  /**
   * index - the index of the set
   */
  public int index;

  /**
   * Constructor that creates a new set object.
   */
  public Set() {
    this.array = new int[DEFAULTLENGTH];
    this.index = 0;
  }

  /**
   *  Constructor that creates a new set object.
   * @param array - the array in the set
   * @param index - the index of the set
   */
  public Set(int[] array, int index) {
    this.array = array;
    this.index = index;
  }

  /**
   * Creates and returns an empty Set.
   * @return set - a new set
   */
  public Set emptySet(){
    return new Set();
  }


  /**
   * Checks if the Set is empty.
   * @return true or false Returns true if the Set contains no items, false otherwise.
   */
  public boolean isEmpty(){
    return this.index == 0;
  }

  /**
   * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
   * @param n - Integer is not already in the Set.
   * @return set - a new set
   */
  public Set add(Integer n){
    for(int i : this.array){
      if(i == n) {
        return new Set(this.array, this.index);
      }
    }
    this.array[index] = n;
    this.index++;
    checkValidIndex(this.index);
    return new Set(this.array, this.index);
  }

  /**
   * check the array is long enough
   * @param length - the length of array
   * @return true or false, if it is long enough return true,
   * return false otherwise
   */
  public boolean checkValidIndex(int length) {
    if (length >= this.array.length) {
      this.array2 = new int[array.length + DEFAULTLENGTH];
      for (int i = 0; i < array.length; i++) {
        array2[i] = array[i];
      }
      this.array = this.array2;
      return false;
    }
    return true;
  }

  /**
   * Returns true if the given Integer is in the Set, false otherwise.
   * @param n - Integer is not already in the Set.
   * @return true or false
   */
  public Boolean contains(Integer n){
    for(int i : this.array){
      if(i == n) return true;
    }
    return false;
  }

  /**
   * Returns a copy of the Set with the given Integer removed.
   * If the given Integer is not in the Set, returns the Set as is.
   * @param n - the given Integer is not in the Set
   * @return set - a new set
   */
  public Set remove(Integer n){
    int position = -1;
    for(int i = 0; i < this.index; i++){
      if(array[i] == n) position = i;
    }
    if(position == -1) return new Set(this.array, this.index);
    for(int i = position; i < this.index - 1; i++){
      this.array[i] = this.array[i + 1];
    }
    this.index--;
    return new Set(this.array, this.index);
  }

  /**
   * Gets the number of items in the Set.
   * @return index - index of size
   */
  public Integer size(){
    return this.index;
  }

  /**
   * an override equal function, if two room objects are equal
   * return true, otherwise return false
   * @param o - the object of input
   * @return true or false, if they are equal, return true, otherwise,
   * return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Set)) {
      return false;
    }
    Set set = (Set) o;
    return index == set.index && array.equals(set.array);
  }

  /**
   * hashcode function, if the two objects are equal, return
   * the same hashcode
   * @return an integer of the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(array, index);
  }

}
