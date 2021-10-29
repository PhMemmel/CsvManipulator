package edv.memmel.csvmanipulator.model;

import edv.memmel.csvmanipulator.model.filehandler.FileImporter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Main data manager class to handle all the csv data. */
public class CsvDataManager {

  private static final CsvDataManager instance = new CsvDataManager();

  private FileImporter fileImporter;
  private List<List<String>> lineList;

  private CsvDataManager() {}

  public void loadFile(String filePath) {
    fileImporter = new FileImporter(filePath);
    lineList = fileImporter.getLineList();
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
    ArrayList<String> linesAsStrings = new ArrayList<>();
    for (List<String> columnList : lineList) {
      linesAsStrings.add(columnList.stream().reduce((acc, item) -> acc += ";" + item).get());
    }
    return linesAsStrings;
  }

  public void addQuotes() {
    ArrayList<List<String>> newList = new ArrayList<>();
    for (List<String> line : lineList) {
      newList.add(line.stream().map(item -> "\"" + item + "\"").collect(Collectors.toList()));
    }
    lineList = newList;
    lineList.forEach(item -> System.out.println(item));
  }
}
