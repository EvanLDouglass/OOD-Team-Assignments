package edu.neu.khoury.cs5004.assignment9.client;

import edu.neu.khoury.cs5004.assignment9.datatypes.PrivateKey;
import edu.neu.khoury.cs5004.assignment9.datatypes.PublicKey;

/**
 * A basic client for the banking system. This class represents the actual client, who has access
 * to their private key for RSA encryption.
 */
public class Client {

  private static Long idCounter = 0L;  // L to denote type long

  private Long id;
  private PrivateKey secretKey;
  private PublicKey publicKey;

  /**
   * Constructor for a {@code Client}. Assigns a unique ID and generates the client's public and
   * private key via the RSA algorithm.
   */
  public Client() {
    // Assign id and increment static var for next instantiation
    id = idCounter++;
    // TODO: put method for RSA alg here: private/public key
  }

  /* ===== Methods ===== */

  /* ===== Getters ===== */

  /**
   * Getter for this client's unique ID.
   *
   * @return a unique ID
   */
  public Long getId() {
    return id;
  }

  /**
   * Getter for this client's public key.
   *
   * @return a public key
   */
  public PublicKey getPublicKey() {
    return publicKey;
  }
}
