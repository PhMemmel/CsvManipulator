package edv.memmel.csvmanipulator.model.filehandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

/** Class writing out a given List to a txt file. */
public class FileExporter {

  private final String outputFileName;

  public FileExporter(String outputFileName) {
    this.outputFileName = outputFileName;
  }

  /**
   * Writes out the given list of strings to a file. Care: The output file will be in the root
   * directory of the class files.
   *
   * @param listToPrint the list to print to a file
   */
  public void dumpToFile(List<String> listToPrint) {

    String dir = Objects.requireNonNull(getClass().getResource("/")).getFile();
    OutputStream outputStream;
    PrintStream printStream;
    try {
      outputStream = new FileOutputStream(dir + outputFileName);
      printStream = new PrintStream(outputStream, true, StandardCharsets.UTF_8);

      // for (String word : listToPrint) wouldn't neccessarily preserve order
      for (int i = 0; i < listToPrint.size(); i++) {
        printStream.println(listToPrint.get(i));
      }
      // the elegant way with stream/lambda/method reference:
      // listToPrint.forEach(printStream::println);

      printStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
