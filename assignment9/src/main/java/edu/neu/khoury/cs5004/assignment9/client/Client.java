package edu.neu.khoury.cs5004.assignment9.client;

import edu.neu.khoury.cs5004.assignment9.rsa.KeyPair;
import edu.neu.khoury.cs5004.assignment9.rsa.MsgSigPair;
import edu.neu.khoury.cs5004.assignment9.rsa.PublicKey;
import edu.neu.khoury.cs5004.assignment9.rsa.RsaKeyGenerator;
import edu.neu.khoury.cs5004.assignment9.rsa.RsaSignatureGenerator;

import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A basic client for the banking system. This class represents the actual client, who has access to
 * their private key for RSA encryption.
 */
public class Client {

  private static final Integer PRIME_BIT_LEN = 512;

  private static AtomicLong idCounter = new AtomicLong(0);  // L to denote type long

  private Long clientId;
  private KeyPair keys;

  /**
   * Constructor for a {@code Client}. Assigns a unique ID and generates the client's public and
   * private key via the RSA algorithm.
   */
  public Client() {
    // Assign id and increment static var for next instantiation
    clientId = idCounter.getAndIncrement();
    // Bit length
    RsaKeyGenerator keyGenerator = new RsaKeyGenerator(PRIME_BIT_LEN);
    keys = keyGenerator.generateKeyPair();
  }

  /* ===== Methods ===== */

  /**
   * Produce a message (e.g. a request for a withdrawal or deposit) with a digital signature used by
   * a signature validator to determine if the message is valid or not. The message represents a
   * dollar amount with the exception of the last digit, which is used to determine if the amount
   * should be a withdrawal or deposit (0-4 is a deposit, 5-9 a withdrawal).
   *
   * @param msg the message/request
   * @return a message-signature pair
   */
  public MsgSigPair requestTransaction(Integer msg) {
    BigInteger signature = RsaSignatureGenerator.signature(msg, keys.getPrivateKey());
    return new MsgSigPair(msg, signature);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Client client = (Client) obj;
    return Objects.equals(clientId, client.clientId)
        && Objects.equals(keys, client.keys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, keys);
  }

  @Override
  public String toString() {
    return String.format("Client{id=%d}", clientId);
  }

  /* ===== Getters ===== */

  /**
   * Getter for this client's unique ID.
   *
   * @return a unique ID
   */
  public Long getClientId() {
    return clientId;
  }

  /**
   * Getter for this client's public key.
   *
   * @return a public key
   */
  public PublicKey getPublicKey() {
    return keys.getPublicKey();
  }

}
