package problem1;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CSVFileProcessorTest {
  private CSVFileProcessor cp;

  @BeforeEach
  void setUp() {
    cp = new CSVFileProcessor();
  }

  @Test
  void getCSVDirectory() {
    cp.getCSVDirectory();
  }

  @Test
  void processCSV() throws RequiredFieldError {
    cp.processCSV("abc.txt");
    cp.processCSV("test_todos.csv");
    cp.processCSV("test_todos2.csv");
  }
}