package edu.neu.ccs.cs5004.assignment10;

import java.util.List;

/**
 * Represents a file parser interface.
 * Created by yanxu on 3/31/17.
 */
public interface FileParser {
  /**
   * Create a new concrete file parser.
   * @return a new concrete file parser
   */
  static FileParser create() {
    return new ConcreteFileParser();
  }

  /**
   * Given the name of file, read and parse it, put the content of the file
   * into a list of strings.
   * @param fileName the name of the file to be parsed
   * @return a list of strings that contains the content of the file
   */
  List<String> parse(String fileName);
}
