package edu.neu.khoury.cs5004.assignment9.rsa;

import java.math.BigInteger;

/**
 * A simple data type for private keys.
 */
public class PrivateKey extends Key {

  /**
   * Constructor for a PrivateKey.
   *
   * @param exponent the first part of the key (the exponent)
   * @param modulus the second part of the key (the modulus)
   */
  public PrivateKey(BigInteger exponent, BigInteger modulus) {
    super(exponent, modulus);
  }

  /* ===== Methods ===== */

  @Override
  public String toString() {
    return "PrivateKey{" + super.toString() + "}";
  }

}
