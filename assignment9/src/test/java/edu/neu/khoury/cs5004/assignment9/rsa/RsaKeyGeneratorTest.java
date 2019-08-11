package edu.neu.khoury.cs5004.assignment9.rsa;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

// Tests for the RSA algs are interdependent in testing full correctness.
public class RsaKeyGeneratorTest {

  private RsaKeyGenerator generator;
  private KeyPair pair;

  @Before
  public void setUp() throws Exception {
    Integer primeLen = 512;
    generator = new RsaKeyGenerator(primeLen);
    pair = generator.generateKeyPair();
  }

  @Test
  public void testSameMod() {
    BigInteger privateMod = pair.getPrivateKey().getModulus();
    BigInteger publicMod = pair.getPublicKey().getModulus();
    assertEquals(privateMod, publicMod);
  }
}