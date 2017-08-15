package edu.neu.ccs.cs5004.assignment10;

/**
 * Represents a header processor interface.
 * Created by yanxu on 4/2/17.
 */
public interface HeaderProcessor {

  /**
   * Create a new concrete header processor.
   * @return a new concrete header processor
   */
  static HeaderProcessor create() {
    return new ConcreteHeaderProcessor();
  }

  /**
   * Given a header, replace the header symbol "#" with the correct numbering.
   * @param header to be processed
   * @return an updated header with the header symbol "#" replaced by numbering
   */
  String process(String header);
}
