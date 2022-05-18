package problem2;

import static java.util.Collections.list;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ListOfString {
  public List<String> list;

  public ListOfString() {
    list = new LinkedList<>();
  }

  public ListOfString(List<String> list) {
    this.list = list;
  }

  public boolean isEmpty(){
    return list.isEmpty();
  }

  public int size(){
    return list.size();
  }

  public boolean contains(String s){
    return list.contains(s);
  }

  public boolean containsAll(ListOfString anotherList){
    for(String string : anotherList.list){
      if(list.contains(string)) continue;
      return false;
    }
    return true;
  }

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

}
