package edu.neu.ccs.cs5004.assignment10;

/**
 * Represents a concrete header numbering interface.
 * Created by yanxu on 4/2/17.
 */
class ConcreteHeaderProcessor implements HeaderProcessor {

  HeaderNumbering num;

  public ConcreteHeaderProcessor() {
    num = HeaderNumbering.create();
  }

  @Override
  public String process(String header) {
    int index = 0;
    while (header.charAt(index) == '#') {
      index++;
    }
    String numbering = num.add(header.substring(0, index));
    return numbering + header.substring(index);
  }
}
