package edv.memmel.csvmanipulator.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** JavaFX Application starter class. */
public class ExampleJavaFxGuiStarter extends Application {

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
    Parent root = fxmlLoader.load();
    primaryStage.setTitle("CSV-Manipulator");
    primaryStage.setScene(new Scene(root, 800, 600));
    primaryStage.show();
  }
}
