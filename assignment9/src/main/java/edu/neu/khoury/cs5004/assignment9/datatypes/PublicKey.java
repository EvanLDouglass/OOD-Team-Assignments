package edu.neu.khoury.cs5004.assignment9.datatypes;

import java.math.BigInteger;

/**
 * A simple data type for public keys.
 */
public class PublicKey extends Key {

  /**
   * Constructor for a PublicKey.
   *
   * @param exponent the first part of the key (the exponent)
   * @param modulus the second part of the key (the modulus)
   */
  public PublicKey(BigInteger exponent, BigInteger modulus) {
    super(exponent, modulus);
  }

  /* ===== Methods ===== */

  @Override
  public String toString() {
    return "PublicKey{" + super.toString() + "}";
  }
}
