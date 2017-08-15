package edu.neu.ccs.cs5004.assignment10;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a concrete list processor.
 * Created by yanxu on 4/1/17.
 */
class ConcreteListProcessor implements ListProcessor{

  @Override
  public List<String> process(List<String> list)
      throws Exception {
    List<String> processedList = new ArrayList<>();
    List<Integer> levels = new ArrayList<>();
    ItemProcessor item = ItemProcessor.create();
    int prevLevel = -1;
    for (int i = 0; i < list.size(); i++) {
      String type = item.type(list.get(i));
      int currentLevel = item.nestingLevels(list.get(i));
      if (levels.isEmpty() && currentLevel != 0) {
        throw new IllegalArgumentException(
            "the first item should has no leading spaces");
      }
      if (currentLevel > prevLevel + 1) {
        throw new IllegalArgumentException(
            "You can't not skipping a nesting level");
      }
      if (currentLevel < prevLevel) {
        for (int j = prevLevel; j > currentLevel; j--) {
          levels.remove(j);
        }
      }
      if (currentLevel == prevLevel + 1) {
        if (type.equals("itemization")) {
          levels.add(0);
        } else {
          levels.add(1);
        }
      } else {
        if ((levels.get(currentLevel) == 0 && type.equals("enumeration"))
            || (levels.get(currentLevel) > 0 && type.equals("itemization"))) {
          throw new IllegalArgumentException(
              "Items on the same nesting levels should have the same type.");
        } else {
          if (levels.get(currentLevel) > 0) {
            levels.set(currentLevel, levels.get(currentLevel) + 1);
          }
        }
      }
      prevLevel = currentLevel;
      processedList.add(
          update(list.get(i), levels.get(currentLevel), currentLevel, type));
    }
    return processedList;
  }

  private String update(String item, int num, int level, String type) {
    int index = 0;
    while (item.charAt(index) == ' ') {
      index++;
    }
    if (type.equals("itemization")) {
      return item.substring(0, index) + "*" + item.substring(index + 1);
    } else {
      String numbering;
      if (level % 2 == 0) {
        numbering = Integer.toString(num) + ".";
      } else {
        MapToAlphabet mapping = new MapToAlphabet();
        numbering = mapping.apply(num) + ".";
      }
      if (item.charAt(index) == '1' && item.charAt(index + 1) == '.') {
        return item.substring(0, index) + numbering
            + item.substring(index + 2);
      } else {
        return item.substring(0, index) + numbering
            + item.substring(index + 1);
      }
    }
  }

  public static void main(String[] args) {
    List<String> temp = new ArrayList<String>();
    temp.add("1. Item, nesting level 1");
    temp.add("  * Item, nesting level 2");
    temp.add("    1. Item, nesting level 3");
    temp.add("      1. Item, nesting level 4");
    temp.add("      1. Item, nesting level 4");
    temp.add("  * Item, nesting level 2");
    temp.add("1. Item, nesting level 1");
    ListProcessor process = ListProcessor.create();
    try {
      List<String> temp2 = process.process(temp);
      for (int i = 0; i < temp2.size(); i++) {
        System.out.println(temp2.get(i));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

}
