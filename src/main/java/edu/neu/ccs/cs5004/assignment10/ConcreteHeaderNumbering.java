package edu.neu.ccs.cs5004.assignment10;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a concrete header numbering interface. The numbering is based
 * on the '#' symbols. The number of '#' symbols indicate the nesting level
 * of headers. The maximum nesting level is 10. If the header nesting level
 * is greater than 10, only keep the first 10 nesting level of the header.
 * In each level, header numbering start at 1 and increase by 1 at the next
 * header with the same level. Header numbering with different level are
 * separated by '.', for example, the numbering for
 * # H
 * # H
 * ## H
 * ## H
 * #### H
 * #### H
 * ############# H
 * are numbered as following:
 * 1 H
 * 2 H
 * 2.1 H
 * 2.2 H
 * 2.2.1.1 H
 * 2.2.1.2 H
 * 2.2.1.2.1.1.1.1.1.1 H
 * Created by yanxu on 3/31/17.
 */
class ConcreteHeaderNumbering implements HeaderNumbering {

  List<Integer[]> level;

  /**
   * Create a new concrete header numbering.
   */
  public ConcreteHeaderNumbering() {
    level = new ArrayList<Integer[]>();
  }

  @Override
  public String add(String header) {
    Integer[] current = new Integer[11];
    int index = level.size();
    int num = header.length();
    String numbering = "";
    Integer[] prev;
    if (index == 0) {
      prev = new Integer[11];
    } else {
      prev = level.get(index - 1);
    }
    int currentLevel = Math.min(10, num);
    if (prev[currentLevel] == null) {
      current[currentLevel] = 1;
    } else {
      current[currentLevel] = prev[currentLevel] + 1;
    }
    numbering = Integer.toString(current[currentLevel]) + numbering;
    for (int i = currentLevel - 1; i >= 1; i--) {
      if (prev[i] == null) {
        current[i] = 1;
      } else {
        current[i] = prev[i];
      }
      numbering = Integer.toString(current[i]) + "." + numbering;
    }
    level.add(current);
    return numbering;
  }

  public static void main(String[] args) {
    ConcreteHeaderNumbering temp = new ConcreteHeaderNumbering();
    System.out.println(temp.add("#"));
    System.out.println(temp.add("#"));
    System.out.println(temp.add("##"));
    System.out.println(temp.add("##"));
    System.out.println(temp.add("#"));
    System.out.println(temp.add("####"));
    System.out.println(temp.add("###"));
    System.out.println(temp.add("####"));
    System.out.println(temp.add("##############"));
    System.out.println(temp.add("#############"));
  }
}
