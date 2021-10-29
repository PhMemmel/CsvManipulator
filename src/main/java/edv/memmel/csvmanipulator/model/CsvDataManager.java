package edv.memmel.csvmanipulator.model;

import edv.memmel.csvmanipulator.model.filehandler.FileImporter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Main data manager class to handle all the csv data. */
public class CsvDataManager {


  private static final CsvDataManager instance = new CsvDataManager();
  private static final String LIST_UPDATED = "listUpdated";

  private PropertyChangeSupport propertyChangeSupport;

  private FileImporter fileImporter;
  private List<List<String>> lineList;

  private CsvDataManager() {
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  public void loadFile(String filePath) {
    fileImporter = new FileImporter(filePath);
    lineList = fileImporter.getLineList();
    propertyChangeSupport.firePropertyChange(LIST_UPDATED, null, null);
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
    propertyChangeSupport.firePropertyChange(LIST_UPDATED, null, null);
  }

  public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
    propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
  }

  public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
    propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
  }
}
