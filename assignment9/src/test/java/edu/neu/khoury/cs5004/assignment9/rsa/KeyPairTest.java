package edu.neu.khoury.cs5004.assignment9.rsa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class KeyPairTest {

  private KeyPair pair;
  private PrivateKey secretKey;
  private PublicKey publicKey;

  @Before
  public void setUp() throws Exception {
    secretKey = new PrivateKey(new BigInteger("12345"), new BigInteger("54321"));
    publicKey = new PublicKey(new BigInteger("56789"), new BigInteger("98765"));
    pair = new KeyPair(secretKey, publicKey);
  }

  @Test
  public void getPrivateKey() {
    assertEquals(secretKey, pair.getPrivateKey());
  }

  @Test
  public void getPublicKey() {
    assertEquals(publicKey, pair.getPublicKey());
  }

  @Test
  public void testEquals() {
    PrivateKey secretKeyAlt = new PrivateKey(new BigInteger("12345"), new BigInteger("54321"));
    PublicKey publicKeyAlt = new PublicKey(new BigInteger("56789"), new BigInteger("98765"));
    KeyPair pairAlt = new KeyPair(secretKeyAlt, publicKeyAlt);

    assertEquals(pair, pair);
    assertEquals(pairAlt, pair);
    assertEquals(pair, pairAlt);
  }

  @Test
  public void testNotEquals() {
    assertNotEquals(null, pair);
    assertNotEquals(pair, null);
    assertNotEquals("String", pair);
    assertNotEquals(pair, secretKey);

    PrivateKey secretKeyAlt = new PrivateKey(new BigInteger("14"), new BigInteger("54321"));
    PublicKey publicKeyAlt = new PublicKey(new BigInteger("56789"), new BigInteger("98765"));
    KeyPair pairAlt = new KeyPair(secretKeyAlt, publicKeyAlt);
    assertNotEquals(pairAlt, pair);

    secretKeyAlt = new PrivateKey(new BigInteger("12345"), new BigInteger("54321"));
    publicKeyAlt = new PublicKey(new BigInteger("-1"), new BigInteger("98765"));
    pairAlt = new KeyPair(secretKeyAlt, publicKeyAlt);
    assertNotEquals(pairAlt, pair);
  }

  @Test
  public void testHashCode() {
    PrivateKey secretKeyAlt = new PrivateKey(new BigInteger("12345"), new BigInteger("54321"));
    PublicKey publicKeyAlt = new PublicKey(new BigInteger("56789"), new BigInteger("98765"));
    KeyPair pairAlt = new KeyPair(secretKeyAlt, publicKeyAlt);

    assertEquals(pair.hashCode(), pair.hashCode());
    assertEquals(pairAlt.hashCode(), pair.hashCode());
  }

  @Test
  public void testHashCodeNotSame() {
    PrivateKey secretKeyAlt = new PrivateKey(new BigInteger("1"), new BigInteger("54321"));
    PublicKey publicKeyAlt = new PublicKey(new BigInteger("56789"), new BigInteger("98765"));
    KeyPair pairAlt = new KeyPair(secretKeyAlt, publicKeyAlt);
    assertNotEquals(pairAlt.hashCode(), pair.hashCode());

    secretKeyAlt = new PrivateKey(new BigInteger("12345"), new BigInteger("54321"));
    publicKeyAlt = new PublicKey(new BigInteger("9"), new BigInteger("98765"));
    pairAlt = new KeyPair(secretKeyAlt, publicKeyAlt);
    assertNotEquals(pairAlt.hashCode(), pair.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "KeyPair{PrivateKey{exponent=12345, modulus=54321}, "
        + "PublicKey{exponent=56789, modulus=98765}}";
    assertEquals(expected, pair.toString());
  }
}