package edu.neu.khoury.cs5004.assignment9.rsa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class MsgSigPairTest {

  private MsgSigPair pair;

  @Before
  public void setUp() throws Exception {
    pair = new MsgSigPair(12345, new BigInteger("9876543210"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMsgNegative() {
    pair = new MsgSigPair(-1, new BigInteger("99999999"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMsgTooBig() {
    pair = new MsgSigPair(30001, new BigInteger("9999999999999"));
  }

  @Test
  public void testEquals() {
    assertEquals(pair, pair);
    MsgSigPair pair1 = new MsgSigPair(12345, new BigInteger("9876543210"));
    assertEquals(pair1, pair);
  }

  @Test
  public void testNotEquals() {
    assertNotEquals(null, pair);
    assertNotEquals("pair", pair);
    assertNotEquals(new BigInteger("1234567890"), pair);

    MsgSigPair pair1 = new MsgSigPair(4321, new BigInteger("9876543210"));
    assertNotEquals(pair1, pair);
    pair1 = new MsgSigPair(12345, new BigInteger("98763210"));
    assertNotEquals(pair1, pair);
  }

  @Test
  public void testHashCodeEquals() {
    assertEquals(pair.hashCode(), pair.hashCode());
    MsgSigPair pair1 = new MsgSigPair(12345, new BigInteger("9876543210"));
    assertEquals(pair1.hashCode(), pair.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    MsgSigPair pair1 = new MsgSigPair(123, new BigInteger("987224532123445543210"));
    assertNotEquals(pair1.hashCode(), pair.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "MsgSigPair{message=12345, signature=9876543210}";
    assertEquals(expected, pair.toString());
  }

  @Test
  public void getMessage() {
    assertEquals(12345, (int) pair.getMessage());
  }

  @Test
  public void getSignature() {
    assertEquals(new BigInteger("9876543210"), pair.getSignature());
  }
}