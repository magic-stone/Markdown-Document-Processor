package edu.neu.ccs.cs5004.assignment10;

import java.util.List;

/**
 * Represents a document processor that given a document in the form of
 * list of strings, process each line and generate the formatted document.
 * Created by yanxu on 4/2/17.
 */
public interface DocumentProcessor {

  /**
   * Create a new concrete document processor.
   * @return a new concrete document processor
   */
  static DocumentProcessor create() {
    return new ConcreteDocumentProcessor();
  }

  /**
   * Given a document in the form of list of strings, process it and return
   * the processed document.
   * @return the processed document in the form of list of strings
   */
  List<String> process(List<String> document);
}
