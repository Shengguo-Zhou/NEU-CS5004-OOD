package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogTest {
  private RecordingArtist recordingArtist, recordingArtist1, recordingArtist2, recordingArtist4;
  private Author author, author1, author2, author4;
  private Band band, band2;
  private Music music1, music2;
  private Book book;
  private Collection collection, collection1, collection2,collection3;
  private Catalog catalog, catalog2, catalog3;

  @BeforeEach
  void setUp() {
    recordingArtist = new RecordingArtist("first","last");
    recordingArtist1 = new RecordingArtist("first1","last");
    recordingArtist2 = new RecordingArtist("first","last1");
    recordingArtist4 = new RecordingArtist("first","last");
    author = new Author("first","last");
    author1 = new Author("first1","last");
    author2 = new Author("first","last1");
    author4 = new Author("first","last");
    LinkedList<RecordingArtist> recordingArtistsMember = new LinkedList<>();
    LinkedList<RecordingArtist> recordingArtistsMember1 = new LinkedList<>();
    recordingArtistsMember.add(recordingArtist);
    recordingArtistsMember.add(recordingArtist1);
    recordingArtistsMember.add(recordingArtist2);
    recordingArtistsMember1.add(recordingArtist1);
    recordingArtistsMember1.add(recordingArtist2);
    band = new Band("first", recordingArtistsMember);
    band2 = new Band("second", recordingArtistsMember1);
    music1 = new Music(recordingArtist);
    music2 = new Music(band);
    book = new Book(author);
    collection = new Collection(recordingArtist, "abc",1999);
    collection1 = new Collection(author, "abc",1999);
    collection2 = new Collection(band, "bc",1999);
    collection3 = new Collection(band2, "bc",1999);
    catalog2 = new Catalog();
    LinkedList<Collection> log = new LinkedList<>();
    LinkedList<Collection> log2 = new LinkedList<>();
    log.add(collection);
    log.add(collection1);
    log.add(collection2);
    log2.add(collection3);
    catalog = new Catalog(log);
    catalog3 = new Catalog(log2);
  }


  @Test
  void addItem() {
    catalog2.addItem(collection);
    assertNotEquals(catalog2, catalog);
  }

  @Test
  void removeItem() {
    catalog2.addItem(collection);
    catalog2.removeItem(collection);
    assertNotEquals(catalog2, catalog);
  }

  @Test
  void search() {
    Catalog testCatalog;
    testCatalog = catalog.search("a");
    Catalog testCatalog2 = new Catalog();
    testCatalog2.addItem(collection);
    testCatalog2.addItem(collection1);
    assertEquals(testCatalog, testCatalog2);
    catalog2.addItem(new Collection(author, "A",1999));
    testCatalog = catalog.search("D");
    assertEquals(testCatalog, testCatalog);
    testCatalog = catalog2.search("a");
    testCatalog = catalog2.search("A");
    assertNotEquals(testCatalog2, testCatalog);
  }

  @Test
  void testSearch() {
    Catalog testCatalog;
    testCatalog = catalog.search(author);
    Catalog testCatalog2 = new Catalog();
    testCatalog2.addItem(collection1);
    assertEquals(testCatalog, testCatalog2);
    testCatalog = catalog.search(author2);
    assertNotEquals(testCatalog, testCatalog2);
  }

  @Test
  void testSearch1() {
    Catalog testCatalog;
    testCatalog = catalog.search(recordingArtist);
    Catalog testCatalog2 = new Catalog();
    testCatalog2.addItem(collection);
    testCatalog2.addItem(collection2);
    assertEquals(testCatalog, testCatalog2);
    testCatalog = catalog.search(recordingArtist2);
    assertNotEquals(testCatalog, testCatalog2);
    Catalog testCatalog3;
    testCatalog3 = catalog3.search(recordingArtist);
    assertEquals(testCatalog3, testCatalog3);
  }

  @Test
  void testEquals() {
    assertEquals(recordingArtist, recordingArtist);
    assertEquals(recordingArtist, recordingArtist4);
    assertNotEquals(recordingArtist, recordingArtist1);
    assertNotEquals(recordingArtist, recordingArtist2);
    assertNotEquals(recordingArtist1, recordingArtist2);
    assertNotEquals(recordingArtist,123);
    assertEquals(author, author);
    assertEquals(author, author4);
    assertNotEquals(author, author1);
    assertNotEquals(author, author2);
    assertNotEquals(author1, author2);
    assertNotEquals(author, 123);
    assertEquals(catalog, catalog);
    assertNotEquals(catalog, catalog2);
    assertNotEquals(catalog, 123);
  }

  @Test
  void testHashCode() {
    assertEquals(recordingArtist.hashCode(), recordingArtist.hashCode());
    assertNotEquals(recordingArtist.hashCode(), recordingArtist1.hashCode());
    assertNotEquals(recordingArtist.hashCode(), recordingArtist2.hashCode());
    assertEquals(author.hashCode(), author.hashCode());
    assertNotEquals(author.hashCode(), author1.hashCode());
    assertNotEquals(author.hashCode(), author2.hashCode());
    assertNotEquals(author.hashCode(), "123".hashCode());
    assertEquals(catalog.hashCode(), catalog.hashCode());
    assertNotEquals(catalog.hashCode(), catalog2.hashCode());
    assertNotEquals(catalog.hashCode(), "123".hashCode());
  }
}