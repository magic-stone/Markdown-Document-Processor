package edu.neu.ccs.cs5004.assignment10;

import java.util.List;

/**
 * Represents the main controller of the text document processor.
 * Created by yanxu on 4/2/17.
 */
class MainController {

  /**
   * Given the command line arguments, checks the validity of the arguments,
   * if the arguments if valid, process the document and generate the output.
   * The name of the output contains the name of the original file plus
   * "_update".
   * @param args command line arguments
   * @throws IllegalArgumentException if the arguments are invalid
   */
  void control(String[] args) throws IllegalArgumentException {
    if (args.length > 1) {
      throw new IllegalArgumentException(
          "You should only provide the name of the document");
    }
    if (args.length == 0) {
      throw new IllegalArgumentException(
          "You need provide the name of the document");
    }
    FileParser parser = FileParser.create();
    List<String> input = parser.parse(args[0]);
    DocumentProcessor processor = DocumentProcessor.create();
    List<String> output = processor.process(input);
    OutputGenerator generator = new OutputGenerator();
    generator.generateOutput(output, args[0] + "_update");
  }

}
