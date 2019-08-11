package edu.neu.khoury.cs5004.assignment9.rsa;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Provides common data and behavior for public and private keys used in RSA key generation and
 * validation. Generally meant only to be a storage class, with RSA algorithms performed outside the
 * class.
 */
public abstract class Key {

  // https://en.wikipedia.org/wiki/RSA_(cryptosystem)#Key_generation for use of field names
  private BigInteger exponent;
  private BigInteger modulus;

  /**
   * Constructor for abstract class Key.
   *
   * @param exponent the first part of the key (the exponent)
   * @param modulus the second part of the key (the modulus)
   */
  public Key(BigInteger exponent, BigInteger modulus) {
    this.exponent = exponent;
    this.modulus = modulus;
  }

  /* ===== Methods ===== */

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Key key = (Key) o;
    return Objects.equals(exponent, key.exponent) &&
        Objects.equals(modulus, key.modulus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exponent, modulus);
  }

  @Override
  public String toString() {
    return "exponent=" + exponent + ", modulus=" + modulus;
  }

  /* ===== Getters ===== */

  /**
   * Getter for exponent.
   *
   * @return the exponent
   */
  public BigInteger getExponent() {
    return this.exponent;
  }

  /**
   * Getter for modulus.
   *
   * @return the modulus
   */
  public BigInteger getModulus() {
    return this.modulus;
  }
}
