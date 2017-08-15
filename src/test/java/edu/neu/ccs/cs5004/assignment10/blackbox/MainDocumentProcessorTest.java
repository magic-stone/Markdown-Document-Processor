package edu.neu.ccs.cs5004.assignment10.blackbox;

import edu.neu.ccs.cs5004.assignment10.MainDocumentProcessor;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by yanxu on 4/3/17.
 */
public class MainDocumentProcessorTest {

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void wrongArgsTest1() throws Exception {
    String[] args = {};
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage
        ("You need provide the name of the document");
    MainDocumentProcessor.main(args);
  }

  @Test
  public void wrongArgsTest2() throws Exception {
    String[] args = {"ABC.test", "BBC.test"};
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage
        ("You should only provide the name of the document");
    MainDocumentProcessor.main(args);
  }

  @Test
  public void mainTest() throws Exception {
    String[] args1 = {"document1"};
    String[] args2 = {"document2"};
    MainDocumentProcessor.main(args1);
    MainDocumentProcessor.main(args2);
    Assert.assertEquals(new String(Files.readAllBytes(Paths.get
        ("document1_expected"))), new String(Files.readAllBytes(Paths.get
        ("document1_update"))));
    Assert.assertEquals(new String(Files.readAllBytes(Paths.get
        ("document2_expected"))), new String(Files.readAllBytes(Paths.get
        ("document2_update"))));
  }
}