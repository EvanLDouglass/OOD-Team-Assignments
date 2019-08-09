package edu.neu.khoury.cs5004.assignment9.bank;

import edu.neu.khoury.cs5004.assignment9.rsa.MsgSigPair;
import edu.neu.khoury.cs5004.assignment9.rsa.RsaSignatureValidator;
import java.util.Map;
import java.util.Objects;

/**
 * The type Bank.It only has one fields, which is the map of client ID and some other information about
 * thi client, for example, some transaction limits and public key. This is because bank only knows part
 * information of clients, and bank needs to find these information by the unique ID.
 */
public class Bank {
  private Map<Long, BankClientTracker> idTracker;

  /**
   * Instantiates a new Bank.
   *
   * @param idTracker the id tracker
   */
  public Bank(
      Map<Long, BankClientTracker> idTracker) {
    this.idTracker = idTracker;
  }

  /**
   * Gets id tracker.
   *
   * @return the id tracker
   */
  public Map<Long, BankClientTracker> getIdTracker() {
    return idTracker;
  }

  /**
   * Sets id tracker.
   *
   * @param idTracker the id tracker
   */
  public void setIdTracker(
      Map<Long, BankClientTracker> idTracker) {
    this.idTracker = idTracker;
  }

  /**
   * Get client info bank client tracker.
   *
   * @param id the id
   * @return the bank client tracker
   */
  public BankClientTracker getClientInfo(Long id){
    return idTracker.get(id);
  }

  /**
   * Verify msg sig pair boolean.
   *
   * @param msgSigPair the msg sig pair
   * @return the boolean
   */
  public boolean verifyMsgSigPair(MsgSigPair msgSigPair) {
    return RsaSignatureValidator.validateSignature(msgSigPair);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Bank bank = (Bank) other;
    return Objects.equals(idTracker, bank.idTracker);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idTracker);
  }

  @Override
  public String toString() {
    return "Bank{"
        + "idTracker="
        + idTracker
        + '}';
  }
}
