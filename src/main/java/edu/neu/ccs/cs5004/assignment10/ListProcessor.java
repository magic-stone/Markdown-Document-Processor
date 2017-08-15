package edu.neu.ccs.cs5004.assignment10;

import java.util.List;

/**
 * Represent a list processor interface.
 * Created by yanxu on 4/1/17.
 */
public interface ListProcessor {

  /**
   * Create a new list processor.
   * @return a new list processor
   */
  static ListProcessor create() {
    return new ConcreteListProcessor();
  }

  /**
   * Given a lists, return a lists with numbering on enumeration and "*" on
   * the itemization. The numbering rules for enumeration:  If we are to count
   * the level of nesting for an enumeration list to start at 1 then all odd
   * nested levels must use numerals for counting and all even nesting levels
   * must use English characters for numbering. For example, given the input:
   * 1. Item, nesting level 1
   *   * Item, nesting level 2
   *     1. Item, nesting level 3
   *       1. Item, nesting level 4
   *       1. Item, nesting level 4
   *     1. Item, nesting level 3
   *   * Item, nesting level 2
   * 1. Item, nesting level 1
   * The output should be:
   * 1. Item, nesting level 1
   *   * Item, nesting level 2
   *     1. Item, nesting level 3
   *       a. Item, nesting level 4
   *       b. Item, nesting level 4
   *     2. Item, nesting level 3
   *   * Item, nesting level 2
   * 2. Item, nesting level 1
   * @param list to be processed
   * @return return a lists with numbering on enumeration and "*" on
   *         the itemization.
   * @throws Exception if the lists has the wrong nesting levels.
   */
  List<String> process(List<String> list) throws Exception;
}
