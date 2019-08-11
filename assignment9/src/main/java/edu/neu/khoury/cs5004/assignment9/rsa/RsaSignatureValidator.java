package edu.neu.khoury.cs5004.assignment9.rsa;

import java.math.BigInteger;

/**
 * Contains a single method to validate a message signature pair.
 */
public class RsaSignatureValidator {

  /* ===== Methods ===== */

  /**
   * Validates a {@code MsgSigPair} given a {@code PublicKey} based on the RSA decryption
   * algorithm.
   *
   * @param msgSigPair a message-signature pair
   * @param key a public key
   * @return true if the message-signature pair is valid, else false
   */
  public static Boolean validate(MsgSigPair msgSigPair, PublicKey key) {
    BigInteger sig = msgSigPair.getSignature();
    BigInteger msgBig = sig.modPow(key.getExponent(), key.getModulus());
    // Get integer value. Since original msg is an int, the calculated value should also be an int.
    // If it is not, the value given will go through int overflow and be extremely unlikely to
    // match the original message.
    Integer msgInt = msgBig.intValue();
    return msgInt.equals(msgSigPair.getMessage());
  }

}
