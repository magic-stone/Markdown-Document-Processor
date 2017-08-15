package edu.neu.ccs.cs5004.assignment10;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.StringJoiner;

/**
 * Represents an output generator.
 * Created by yanxu on 3/29/17.
 */
class OutputGenerator {

  /**
   * Given the content{@code content} of the output file, generate a new file
   * with the given file name{@code fileName} at the default folder.
   * @param content content of the output file
   * @param fileName name of the output file
   */
  public void generateOutput(List<String> content, String fileName) {
    try (BufferedWriter output = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(fileName),
            StandardCharsets.UTF_8))) {
      StringJoiner document = new StringJoiner(System.lineSeparator());
      for (int i = 0; i < content.size(); i++) {
        document.add(content.get(i));
      }
      output.write(document.toString());
    } catch (FileNotFoundException f1) {
      System.out.println("*** OUPS! A file was not found : " + f1.getMessage());
      f1.printStackTrace();
    } catch (IOException i1) {
      System.out.println("Something went wrong! : " + i1.getMessage());
      i1.printStackTrace();
    }
  }
}
