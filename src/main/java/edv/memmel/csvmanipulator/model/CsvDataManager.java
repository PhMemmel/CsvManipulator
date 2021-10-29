package edv.memmel.csvmanipulator.model;

import edv.memmel.csvmanipulator.model.filehandler.FileImporter;
import java.util.List;

/**
 * Main data manager class to handle all the csv data.
 */
public class CsvDataManager {

  private static final CsvDataManager instance = new CsvDataManager();

  FileImporter fileImporter;

  private CsvDataManager() {
  }

  public void loadFile(String filePath) {
    fileImporter = new FileImporter(filePath);
  }

  public static CsvDataManager getInstance() {
    return instance;
  }

  /**
   * Returns a list of strings: Each string is one line of the parsed CSV file.
   *
   * @return list of lines of the parsed CSV file
   */
  public List<String> getCsvFileLines() {
    return fileImporter.getLineList();
  }
}
