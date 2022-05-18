package problem2;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;

/**
 * Represent the catalog class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Catalog {

  /**
   * library - the whole library catalog
   */
  public LinkedList<Collection> library;

  /**
   * construtor - create a catalog class
   */
  public Catalog() {
    this.library = new LinkedList<>();
  }

  /**
   * construtor - create a catalog class
   * @param library - the whole library catalog
   */
  public Catalog(LinkedList<Collection> library) {
    this.library = library;
  }

  /**
   * add the item to library
   * @param collection - the package of the library
   */
  public void addItem(Collection collection){
    library.add(collection);
  }

  /**
   * remove the item from the library
   * @param collection - the package of the libarary
   */
  public void removeItem(Collection collection){
    library.remove(collection);
  }

  /**
   * search the keyword in catalog
   * @param keyword - the key word
   * @return a new catalog
   */
  public Catalog search(String keyword){
    Catalog newCatalog = new Catalog();
    for(Collection collection : this.library){
      if(collection.title.contains(keyword.toLowerCase()) ||
      collection.title.contains(keyword.toUpperCase()))
        newCatalog.addItem(collection);
    }
    return newCatalog;
  }

  /**
   * search author in the string
   * @param author - the author of the catalog
   * @return a new catalog
   */
  public Catalog search(Author author){
    Catalog newCatalog = new Catalog();
    for(Collection collection : this.library){
      if(collection.creator instanceof Author && collection.creator == author)
        newCatalog.addItem(collection);
    }
    return newCatalog;
  }

  /**
   * search an artist from the string
   * @param artist - the artist of the recording artist
   * @return a new catalog
   */
  public Catalog search(RecordingArtist artist){
    Catalog newCatalog = new Catalog();
    for(Collection collection : this.library){
      if(collection.creator instanceof RecordingArtist &&
          collection.creator == artist)
        newCatalog.addItem(collection);
      else if(collection.creator instanceof Band &&
          ((Band) collection.creator).member.contains(artist))
        newCatalog.addItem(collection);
    }
    return newCatalog;
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
    if (!(o instanceof Catalog)) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return Objects.equals(library, catalog.library);
  }

  /**
   * hashcode function, if the two objects are equal, return
   * the same hashcode
   * @return an integer of the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(library);
  }
}
