package edv.memmel.csvmanipulator.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvDataManagerTest {

  @BeforeEach
  void setUp() {
    CsvDataManager.getInstance().loadFile("/Adressen.csv");
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void addQuotes() {
    final String expectedResult = "\"Gerhild\";\"Dutugauson\";\"Dahlienweg 123\";\"72818\";\"Trochtelfingen\";\"06623/977694922\";\"gerhild.dutugauson60@gmx.de\"";
    CsvDataManager.getInstance().addQuotes();
    Assertions.assertEquals(expectedResult, CsvDataManager.getInstance().getCsvFileLines().get(0));
  }
}