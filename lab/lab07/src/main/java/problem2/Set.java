package problem2;

import java.util.HashSet;

public class Set {

  private HashSet<Integer> set = new HashSet<>();

  public Set() {}

  public HashSet<Integer> emptySet(){return this.set;}

  public boolean isEmpty(){return this.set.isEmpty();}

  public HashSet<Integer> add(int n){
    if(this.set.contains(n)) return this.set;
    else this.set.add(n);
    return this.set;
  }

  public boolean contains(int n){
    return this.set.contains(n);
  }

  public HashSet<Integer> remove(int ele){
    if(this.set.contains(ele)) set.remove(ele);
    return this.set;
  }

  public int size(){
    return this.set.size();
  }

}
