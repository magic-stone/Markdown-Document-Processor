package edu.neu.ccs.cs5004.assignment10;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a concrete document processor.
 * Created by yanxu on 4/2/17.
 */
class ConcreteDocumentProcessor implements DocumentProcessor {

  @Override
  public List<String> process(List<String> document) {
    List<String> update = new ArrayList<String>();
    PrototypeProcessor prototype = PrototypeProcessor.create();
    HeaderProcessor header = HeaderProcessor.create();
    ListProcessor list = ListProcessor.create();
    int index = 0;
    while (index < document.size()) {
      String current = document.get(index);
      String type = prototype.type(current);
      switch (type) {
        case "header":
          update.add(header.process(current));
          break;
        case "paragraph":
          update.add(current);
          break;
        case "empty":
          update.add("");
          break;
        case "list":
          List<String> theList = new ArrayList<String>();
          while (prototype.type(current).equals("list")) {
            theList.add(current);
            index++;
            if (index >= document.size()) {
              break;
            }
            current = document.get(index);
          }
          try {
            List<String> updatedList = list.process(theList);
            for (int i = 0; i < updatedList.size(); i++) {
              update.add(updatedList.get(i));
            }
          } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
          }
          index--;
          break;
        default:
          break;
      }
      index++;
    }
    return update;
  }
}
