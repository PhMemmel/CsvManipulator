package edv.memmel.csvmanipulator.view;

import edv.memmel.csvmanipulator.model.CsvDataManager;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/** FX controller class for main window. */
public class MainWindowFxController {

  @FXML ScrollPane linesScrollPane;
  @FXML TextField fileNameTextField;
  VBox rowBox;
  CsvDataManager csvDataManager;

  public MainWindowFxController() {
    csvDataManager = CsvDataManager.getInstance();
  }

  @FXML
  void initialize() {
    rowBox = new VBox();
    linesScrollPane.setContent(rowBox);
    fileNameTextField.setText("/Adressen.csv");
  }

  @FXML
  void triggerFileLoad() {
    csvDataManager.loadFile(fileNameTextField.getText());
    List<String> stringList = CsvDataManager.getInstance().getCsvFileLines();
    rowBox.getChildren().clear();
    for (String line : stringList) {
      Label stringLabel = new Label(line);
      rowBox.getChildren().add(stringLabel);
    }
  }
}
