package edu.neu.ccs.cs5004.assignment10;

/**
 * Represents a concrete prototype processor.
 * Created by yanxu on 4/2/17.
 */
class ConcretePrototypeProcessor implements PrototypeProcessor {

  @Override
  public String type(String line) {
    if (line.equals("")) {
      return "empty";
    }
    if (line.charAt(0) == '#') {
      return "header";
    }
    int index = 0;
    while (line.charAt(index) == ' ') {
      index++;
    }
    char symbol = line.charAt(index);
    if (symbol == '*' || symbol == '+' || symbol == '-' || symbol == '1'
        || symbol == '.') {
      return "list";
    }
    return "paragraph";
  }
}
