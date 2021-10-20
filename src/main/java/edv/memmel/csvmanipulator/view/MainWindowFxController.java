package edv.memmel.csvmanipulator.view;

import edv.memmel.csvmanipulator.model.CsvDataManager;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/** FX controller class for main window. */
public class MainWindowFxController {

  @FXML ScrollPane linesScrollPane;

  @FXML
  void initialize() {
    VBox rowBox = new VBox();
    linesScrollPane.setContent(rowBox);
    List<String> stringList = CsvDataManager.getInstance().getCsvFileLines();
    for (String line : stringList) {
      Label stringLabel = new Label(line);
      rowBox.getChildren().add(stringLabel);
    }
  }
}
