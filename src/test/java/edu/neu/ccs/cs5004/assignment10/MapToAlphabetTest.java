package edu.neu.ccs.cs5004.assignment10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yanxu on 4/3/17.
 */
public class MapToAlphabetTest {

  MapToAlphabet map;

  @Before
  public void setUp() throws Exception {
    map = new MapToAlphabet();
  }

  @Test
  public void apply() throws Exception {
    Assert.assertEquals("a", map.apply(1));
    Assert.assertEquals("b", map.apply(2));
    Assert.assertEquals("f", map.apply(6));
    Assert.assertEquals("n", map.apply(14));
    Assert.assertEquals("q", map.apply(17));
    Assert.assertEquals("w", map.apply(23));
    Assert.assertEquals("z", map.apply(26));
    Assert.assertEquals("aa", map.apply(27));
    Assert.assertEquals("af", map.apply(32));
    Assert.assertEquals("az", map.apply(52));
    Assert.assertEquals("ba", map.apply(53));
    Assert.assertEquals("bx", map.apply(76));
    Assert.assertEquals("aps", map.apply(1111));
  }

}