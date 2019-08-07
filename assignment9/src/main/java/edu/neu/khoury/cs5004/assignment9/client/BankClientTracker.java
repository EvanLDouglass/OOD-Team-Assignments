package edu.neu.khoury.cs5004.assignment9.client;

import edu.neu.khoury.cs5004.assignment9.datatypes.PublicKey;

/**
 * A {@code BankClientTracker} keeps track of {@code Client}s of a bank, however, it does not have
 * access to the client's private key. Also tracks fields that are not visible to the client
 * including a deposit limit and a withdraw limit.
 */
public class BankClientTracker {

  // A full client is not stored in this class because it would not be reasonable to the bank to
  // use the client reference to send messages for the client with their digital signature.
  private Long id;
  private PublicKey publicKey;
  private Integer depositLimit;
  private Integer withdrawLimit;

  /**
   * Constructor for a {@code BankClient}.
   *
   * @param depositLimit the deposit limit for this client
   * @param withdrawLimit the withdraw limit for this client
   */
  public BankClientTracker(Client client, Integer depositLimit, Integer withdrawLimit) {
    this.id = client.getId();
    this.publicKey = client.getPublicKey();
    // These limits should be set randomly outside of this class for the simulator, as they would
    // not be set randomly for a real bank client.
    this.depositLimit = depositLimit;
    this.withdrawLimit = withdrawLimit;
  }

  /* ===== Methods ===== */

  /* ===== Getters & Setters ===== */

  /**
   * Getter for the client's unique id.
   *
   * @return an id number
   */
  public Long getId() {
    return id;
  }

  /**
   * Getter for the client's public key.
   *
   * @return the public key
   */
  public PublicKey getPublicKey() {
    return publicKey;
  }

  /**
   * Getter for this client's deposit limit.
   *
   * @return the deposit limit
   */
  public Integer getDepositLimit() {
    return depositLimit;
  }

  /**
   * Setter for this client's deposit limit.
   *
   * @param depositLimit the new deposit limit
   */
  public void setDepositLimit(Integer depositLimit) {
    this.depositLimit = depositLimit;
  }

  /**
   * Getter for this client's withdraw limit.
   *
   * @return the withdraw limit
   */
  public Integer getWithdrawLimit() {
    return withdrawLimit;
  }

  /**
   * Setter for this client's withdraw limit.
   *
   * @param withdrawLimit the new withdraw limit
   */
  public void setWithdrawLimit(Integer withdrawLimit) {
    this.withdrawLimit = withdrawLimit;
  }
}
