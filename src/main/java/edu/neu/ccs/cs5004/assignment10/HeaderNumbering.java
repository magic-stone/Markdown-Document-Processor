package edu.neu.ccs.cs5004.assignment10;

/**
 * Represents a header numbering interface.
 * Created by yanxu on 3/31/17.
 */
public interface HeaderNumbering {

  /**
   * Create a new concrete header numbering.
   * @return a new concrete header numbering.
   */
  static HeaderNumbering create() {
    return new ConcreteHeaderNumbering();
  }

  /**
   * Add a header and numbering it.
   * @param header to be added
   * @return the numbering of the header just added
   */
  String add(String header);
}
