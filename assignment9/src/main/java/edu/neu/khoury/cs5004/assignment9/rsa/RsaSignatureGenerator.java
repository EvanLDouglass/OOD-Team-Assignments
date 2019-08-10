package edu.neu.khoury.cs5004.assignment9.rsa;

import java.math.BigInteger;

/**
 * Simply generates a digital signature given a message and a private RSA key.
 */
public class RsaSignatureGenerator {

  /**
   * Computes a digital signature using this private key, given an integer message.
   *
   * @param message the message to make a signature for
   * @return the computed digital signature
   */
  public static BigInteger signature(Integer message, PrivateKey key) {
    BigInteger msgBig = new BigInteger(message.toString());
    return msgBig.modPow(key.getExponent(), key.getModulus());
  }
}
