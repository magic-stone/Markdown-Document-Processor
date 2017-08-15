package edu.neu.ccs.cs5004.assignment10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a concrete file parser.
 * Created by yanxu on 3/29/17.
 */
class ConcreteFileParser implements FileParser {

  @Override
  public List<String> parse(String fileName) {
    ArrayList<String> lines = new ArrayList<String>();
    try (BufferedReader inputFile = new BufferedReader(
        new InputStreamReader(new FileInputStream(fileName),
            StandardCharsets.UTF_8))) {
      String line;
      while ((line = inputFile.readLine()) != null) {
        lines.add(line);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
    return lines;
  }
}