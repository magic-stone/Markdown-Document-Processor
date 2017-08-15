package edu.neu.ccs.cs5004.assignment10;

/**
 * Represent an item of list processor interface.
 * Created by yanxu on 4/1/17.
 */
public interface ItemProcessor {

  /**
   * Create a new item of list processor.
   * @return a new item of list processor
   */
  static ItemProcessor create() {
    return new ConcreteItemProcessor();
  }
  /**
   * Return the type of the current item{@code item}.
   * @param item the current item in the list
   * @return the type of the current item, should be either "itemization", or
   *         "enumeration". For "itemization", the item starts with "*" or "+"
   *         , or "-" , followed by 1 space. For "enumeration", the item
   *         starts with either "." or "1.", followed by 1 space.
   */
  String type(String item);

  /**
   * Return the nesting levels of the current item{@code item}.
   * @param item the current item in the list
   * @return the nesting levels of the current item. The nesting level is
   *         determined by the number of the leading spaces. The number of
   *         the leading spaces should be an even number, for example, 0, 2
   *         , 4, 6, 8. The nesting levels is the number of the leading spaces
   *         divided by 2.
   * @throws Exception if the number of the leading spaces is an odd number
   */
  int nestingLevels(String item) throws Exception;
}
