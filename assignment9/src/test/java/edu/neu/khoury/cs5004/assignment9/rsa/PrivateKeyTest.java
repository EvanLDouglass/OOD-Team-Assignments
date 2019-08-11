package edu.neu.khoury.cs5004.assignment9.rsa;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class PrivateKeyTest {

  private PrivateKey key;

  @Before
  public void setUp() throws Exception {
    key = new PrivateKey(new BigInteger("1234567890"), new BigInteger("9876543210"));
  }

  @Test
  public void testToString() {
    String expected = "PrivateKey{exponent=1234567890, modulus=9876543210}";
    assertEquals(expected, key.toString());
  }

}