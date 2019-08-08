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

  /**
   * Computes a digital signature using this private key, given an integer message.
   *
   * @param message the message to make a signature for
   * @return the computed digital signature
   */
  public BigInteger generateSignature(Integer message) {
    BigInteger msgBig = new BigInteger(message.toString());
    return msgBig.modPow(getExponent(), getModulus());
  }
}
