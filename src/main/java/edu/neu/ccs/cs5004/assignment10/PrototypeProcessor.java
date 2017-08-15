package edu.neu.ccs.cs5004.assignment10;

/**
 * Represents a prototype processor.
 * Created by yanxu on 4/2/17.
 */
public interface PrototypeProcessor {

  /**
   * Create a new prototype processor.
   * @return a new prototype processor
   */
  static PrototypeProcessor create() {
    return new ConcretePrototypeProcessor();
  }

  /**
   * Given a line of document, return the type of it.
   * @param line a line of document
   * @return the type of the line, could be "header", "paragraph", "lists",
   *         "empty"
   */
  String type(String line);
}
