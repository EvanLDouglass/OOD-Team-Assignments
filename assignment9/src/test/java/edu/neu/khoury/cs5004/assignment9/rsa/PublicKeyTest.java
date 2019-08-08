package edu.neu.khoury.cs5004.assignment9.rsa;

import static org.junit.Assert.*;

import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class PublicKeyTest {

  private PublicKey key;

  @Before
  public void setUp() throws Exception {
    key = new PublicKey(new BigInteger("1234567890"), new BigInteger("9876543210"));
  }

  @Test
  public void testEquals() {
    assertEquals(key, key);
    PublicKey key1 = new PublicKey(new BigInteger("1234567890"), new BigInteger("9876543210"));
    assertEquals(key1, key);
  }

  @Test
  public void testNotEquals() {
    assertNotEquals(null, key);
    assertNotEquals("key", key);
    assertNotEquals(new BigInteger("123"), key);

    PublicKey key1 = new PublicKey(new BigInteger("123456890"), new BigInteger("9876543210"));
    assertNotEquals(key1, key);
    key1 = new PublicKey(new BigInteger("1234567890"), new BigInteger("98743210"));
    assertNotEquals(key1, key);
  }

  @Test
  public void testHashCodeEquals() {
    assertEquals(key.hashCode(), key.hashCode());
    PublicKey key1 = new PublicKey(new BigInteger("1234567890"), new BigInteger("9876543210"));
    assertEquals(key1.hashCode(), key.hashCode());
  }

  @Test
  public void testHashCodeNotEquals() {
    PublicKey key1 = new PublicKey(new BigInteger("123456890"), new BigInteger("9876543210"));
    assertNotEquals(key1.hashCode(), key.hashCode());
    key1 = new PublicKey(new BigInteger("1234567890"), new BigInteger("987543210"));
    assertNotEquals(key1.hashCode(), key.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "PublicKey{exponent=1234567890, modulus=9876543210}";
    assertEquals(expected, key.toString());
  }

  @Test
  public void getExponent() {
    assertEquals(new BigInteger("1234567890"), key.getExponent());
  }

  @Test
  public void getModulus() {
    assertEquals(new BigInteger("9876543210"), key.getModulus());
  }
}