package edu.neu.ccs.cs5004.assignment10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yanxu on 4/3/17.
 */
public class HeaderNumberingTest {

  HeaderNumbering num;

  @Before
  public void setUp() throws Exception {
    num = HeaderNumbering.create();
  }

  @Test
  public void add() throws Exception {
    Assert.assertEquals("1", num.add("#"));
    Assert.assertEquals("2", num.add("#"));
    Assert.assertEquals("2.1", num.add("##"));
    Assert.assertEquals("2.2", num.add("##"));
    Assert.assertEquals("2.2.1.1", num.add("####"));
    Assert.assertEquals("2.2.2", num.add("###"));
    Assert.assertEquals("2.2.2.1.1", num.add("#####"));
    Assert.assertEquals("2.2.3", num.add("###"));
    Assert.assertEquals("2.3", num.add("##"));
    Assert.assertEquals("3", num.add("#"));
  }

}