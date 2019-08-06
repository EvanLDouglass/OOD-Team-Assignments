package edu.neu.khoury.cs5004.assignment9.client;

/**
 * A {@code BankClient} adds functionality to a basic {@code Client}, however, it does not have
 * access to the basic client's private key. Added fields that are not visible to the basic client
 * include a deposit limit and a withdraw limit.
 */
public class BankClient extends Client {

  private Integer depositLimit;
  private Integer withdrawLimit;

  /**
   * Constructor for a {@code BankClient}.
   *
   * @param depositLimit the deposit limit for this client
   * @param withdrawLimit the withdraw limit for this client
   */
  public BankClient(Integer depositLimit, Integer withdrawLimit) {
    super();
    // These limits should be set randomly outside of this class for the simulator, as they would
    // not be set randomly for a real bank client.
    this.depositLimit = depositLimit;
    this.withdrawLimit = withdrawLimit;
  }

  /* ===== Methods ===== */

  /* ===== Getters & Setters ===== */

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
