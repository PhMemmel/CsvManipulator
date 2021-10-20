package edv.memmel.csvmanipulator.model.filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** FileParser class. Parses a file and stores its content in a Set. */
public class FileImporter {

  private String fileNameToRead;
  private List<String> lines;

  /**
   * FileImporter class.
   *
   * @param fileNameToRead the file name of the file to read in, the path has to be relative to the
   *     directory "src/"
   */
  public FileImporter(String fileNameToRead) {
    this.fileNameToRead = fileNameToRead;
    lines = new ArrayList<>();
    readInLines();
  }

  private void readInLines() {
    File wordsFile =
        new File(Objects.requireNonNull(getClass().getResource(fileNameToRead)).getFile());
    BufferedReader bufferedFileReader;
    try {
      bufferedFileReader = new BufferedReader(new FileReader(wordsFile, StandardCharsets.UTF_8));
    } catch (FileNotFoundException e) {
      System.out.println("File " + fileNameToRead + " not found!");
      return;
    } catch (IOException e) {
      System.out.println("Wrong encoding!");
      return;
    }
    System.out.println("Parsing file into collection...");

    String tmp;
    try {
      while (bufferedFileReader.ready()) {
        tmp = bufferedFileReader.readLine();
        lines.add(tmp);
        // debug output:
        System.out.println("Read line: " + tmp);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // the elegant way using stream and lambda expression
    /*bufferedFileReader
    .lines()
    .forEach(
        word -> {
          word = word.trim();
          if (!words.contains(word)) {
            words.add(word);
          }
        });*/
    try {
      bufferedFileReader.close();
    } catch (IOException e) {
      System.out.println("Couldn't close stream.");
      e.printStackTrace();
    }
  }

  public List<String> getLineList() {
    return lines;
  }
}
