package edu.neu.ccs.cs5004.assignment10;

/**
 * Represent a document processor main controller.
 * Created by yanxu on 4/2/17.
 */
public class MainDocumentProcessor {

  /**
   * The entry of our program. You need provide the file name of the
   * original document.
   * @param args command line arguments
   */
  public static void main(String[] args) {
    MainController controller = new MainController();
    controller.control(args);
  }
}
