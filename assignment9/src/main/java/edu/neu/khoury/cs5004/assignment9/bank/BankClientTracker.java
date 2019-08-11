package edu.neu.khoury.cs5004.assignment9.bank;

import edu.neu.khoury.cs5004.assignment9.rsa.PublicKey;

import java.util.Objects;

/**
 * A {@code BankClientTracker} keeps track of {@code Client}s of a bank, however, it does not have
 * access to the client's private key. Also tracks fields that are not visible to the client
 * including a deposit limit and a withdraw limit.
 */
public class BankClientTracker {

  // A full client is not stored in this class because it would not be reasonable to the bank to
  // use the client reference to send messages for the client with their digital signature.
  private PublicKey publicKey;
  private Integer depositLimit;
  private Integer withdrawLimit;


  /**
   * Instantiates a new Bank client tracker.
   *
   * @param publicKey the public key
   * @param depositLimit the deposit limit
   * @param withdrawLimit the withdraw limit
   */
  public BankClientTracker(PublicKey publicKey, Integer depositLimit, Integer withdrawLimit) {
    this.publicKey = publicKey;
    this.depositLimit = depositLimit;
    this.withdrawLimit = withdrawLimit;
  }

  /**
   * Gets public key.
   *
   * @return the public key
   */
  public PublicKey getPublicKey() {
    return publicKey;
  }

  /**
   * Sets public key.
   *
   * @param publicKey the public key
   */
  public void setPublicKey(PublicKey publicKey) {
    this.publicKey = publicKey;
  }

  /**
   * Gets deposit limit.
   *
   * @return the deposit limit
   */
  public Integer getDepositLimit() {
    return depositLimit;
  }

  /**
   * Sets deposit limit.
   *
   * @param depositLimit the deposit limit
   */
  public void setDepositLimit(Integer depositLimit) {
    this.depositLimit = depositLimit;
  }

  /**
   * Gets withdraw limit.
   *
   * @return the withdraw limit
   */
  public Integer getWithdrawLimit() {
    return withdrawLimit;
  }

  /**
   * Sets withdraw limit.
   *
   * @param withdrawLimit the withdraw limit
   */
  public void setWithdrawLimit(Integer withdrawLimit) {
    this.withdrawLimit = withdrawLimit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankClientTracker that = (BankClientTracker) o;
    return Objects.equals(publicKey, that.publicKey)
        && Objects.equals(depositLimit, that.depositLimit)
        && Objects.equals(withdrawLimit, that.withdrawLimit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(publicKey, depositLimit, withdrawLimit);
  }

  @Override
  public String toString() {
    return "BankClientTracker{"
        + "publicKey=" + publicKey
        + ", depositLimit=" + depositLimit
        + ", withdrawLimit=" + withdrawLimit
        + '}';
  }
}