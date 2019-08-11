package edu.neu.khoury.cs5004.assignment9.rsa;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class RsaSignatureGeneratorTest {

  private PrivateKey key;

  @Before
  public void setUp() throws Exception {
    key = new PrivateKey(new BigInteger("1234567890"), new BigInteger("9876543210"));
  }

  @Test
  public void testGenerateSignature() {
    BigInteger result = RsaSignatureGenerator.signature(1000, key);
    assertEquals(new BigInteger("3939836590"), result);
  }
}