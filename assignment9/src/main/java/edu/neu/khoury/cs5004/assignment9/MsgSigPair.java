package edu.neu.khoury.cs5004.assignment9;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Represents a message/signature pair for the secure bank simulator. Both the message and signature
 * are integers. The signature should be generated by the RSA algorithm prior to storing it in a
 * {@code MsgSigPair}.
 *
 * @author evandouglass
 */
public class MsgSigPair {

  private Integer message;
  private BigInteger signature;

  /**
   * Constructor for {@code MsgSigPair}.
   *
   * @param message an integer message representing a type of transaction and an amount
   * @param signature a digital signature
   */
  public MsgSigPair(Integer message, BigInteger signature) throws IllegalArgumentException {
    new MsgSigValidator().validate(message);
    this.message = message;
    this.signature = signature;
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
    MsgSigPair that = (MsgSigPair) o;
    return message.equals(that.message)
        && signature.equals(that.signature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, signature);
  }

  @Override
  public String toString() {
    return String.format("MsgSigPair{message=%d, signature=%d}", message, signature);
  }

  /* ===== Getters ===== */

  /**
   * Getter for the message.
   *
   * @return the message
   */
  public Integer getMessage() {
    return message;
  }

  /**
   * Getter for the signature.
   *
   * @return the signature
   */
  public BigInteger getSignature() {
    return signature;
  }

  /* ===== Validator Class ===== */

  /**
   * Validates the fields in a MsgSigPair.
   */
  private class MsgSigValidator {

    /**
     * Main validator method.
     *
     * @param msg the message
     * @throws IllegalArgumentException if msg is not in the set [0, 30000]
     */
    public void validate(Integer msg) throws IllegalArgumentException {
      checkMsgPositive(msg);
      checkMsgMax(msg);
    }

    /**
     * Ensures message is positive or 0.
     *
     * @param msg the message
     * @throws IllegalArgumentException if message is negative
     */
    private void checkMsgPositive(Integer msg) throws IllegalArgumentException {
      if (msg < 0) {
        throw new IllegalArgumentException("Message cannot be negative.");
      }
    }

    /**
     * Ensures message is no more than 30,000.
     *
     * @param msg the message
     * @throws IllegalArgumentException if message is more than 30,000
     */
    private void checkMsgMax(Integer msg) throws IllegalArgumentException {
      Integer maxInt = 30000;
      if (msg > maxInt) {
        throw new IllegalArgumentException("Message cannot be more than 30000");
      }
    }
  }
}
