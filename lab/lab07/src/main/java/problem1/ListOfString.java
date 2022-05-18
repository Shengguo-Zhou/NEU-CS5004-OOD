package problem1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ListOfString {
  public List<String> list;

  public ListOfString() {
    list = new LinkedList<>();
  }

  // A constructor.
  public ListOfString(List<String> list) {
    this.list = list;
  }

  /**
   * Returns true if the list is empty, false otherwise
   *
   * @return The boolean value of whether the list is empty or not.
   */
  public boolean isEmpty(){
    return list.isEmpty();
  }

  public int size(){
    return list.size();
  }

  public boolean contains(String s){
    return list.contains(s);
  }

  /**
   * Returns true if the list contains all the strings in anotherList
   *
   * @param anotherList The list to compare to this list.
   * @return A boolean value.
   */
  public boolean containsAll(ListOfString anotherList){
    for(String string : anotherList.list){
      if(list.contains(string)) continue;
      return false;
    }
    return true;
  }

  /**
   * Given a list of strings, return a list of strings that are longer than a given number
   *
   * @param max the maximum length of a string in the list
   * @return A new ListOfString object.
   */
  public ListOfString filerLargerThan(int max){
    ListOfString newList = new ListOfString();
    for(String s : list){
      if(s.length() <= max) continue;
      newList.list.add(s);
    }
    return newList;
  }

  public boolean hasDuplicates(){
    HashSet<String> set = new HashSet<>();
    for(String s : list)
      if(!set.add(s)) return true;
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ListOfString)) {
      return false;
    }
    ListOfString that = (ListOfString) o;
    return list.equals(that.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }

  /**
   * Given a list of strings, remove all duplicates from the list
   *
   * @return A list of strings
   */
  public ListOfString removeDuplicate(){
    HashSet<String> set = new HashSet<>();
    for(String s : list){
      if(set.isEmpty()) set.add(s);
      else if(set.contains(s)) continue;
      else set.add(s);
    }
    List<String> newList = new LinkedList<>();
    for(String s : set)
      newList.add(s);
    return new ListOfString(newList);
  }

  /**
   * Given a list of strings, return true if the list contains a string that contains the given element
   *
   * @param element the element to search for
   * @return A boolean value.
   */
  public boolean contains(int element){
    for(String str : list){
      if(str.contains(Integer.toString(element)))
        return true;
    }
    return false;
  }

  /**
   * Given an index, return the element at that index
   *
   * @param index the index of the element to be returned.
   * @return The element at the given index.
   */
  public int elementAt(int index) throws OutOfBoundary {
    if(index >= list.size())
      throw new OutOfBoundary("out of boundary");
    else
      return Integer.valueOf(this.list.get(index));
  }

}

