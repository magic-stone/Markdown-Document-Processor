package edu.neu.ccs.cs5004.assignment10;

/**
 * Represents a concrete item of list processor.
 * Created by yanxu on 4/1/17.
 */
class ConcreteItemProcessor implements ItemProcessor {

  @Override
  public String type(String item) {
    int index = 0;
    while (item.charAt(index) == ' ') {
      index++;
    }
    char cur = item.charAt(index);
    if (cur == '*' || cur == '+' || cur == '-') {
      return "itemization";
    }
    return "enumeration";
  }

  @Override
  public int nestingLevels(String item) throws IllegalArgumentException {
    int index = 0;
    while (item.charAt(index) == ' ') {
      index++;
    }
    if (index % 2 != 0) {
      throw new IllegalArgumentException(
          "the number of the leading spaces should be multiples of 2");
    }
    return index / 2;
  }
}
