package edu.neu.khoury.cs5004.assignment9.rsa;

import java.util.Objects;

/**
 * The type Key pair. It has two parts, the public key and private key.
 */
public class KeyPair {
  private PrivateKey privateKey;
  private PublicKey publicKey;

  /**
   * Instantiates a new Key pair.
   *
   * @param privateKey the private key
   * @param publicKey the public key
   */
  public KeyPair(PrivateKey privateKey, PublicKey publicKey) {
    this.privateKey = privateKey;
    this.publicKey = publicKey;
  }

  /**
   * Gets private key.
   *
   * @return the private key
   */
  public PrivateKey getPrivateKey() {
    return privateKey;
  }

  /**
   * Gets public key.
   *
   * @return the public key
   */
  public PublicKey getPublicKey() {
    return publicKey;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyPair keyPair = (KeyPair) o;
    return Objects.equals(privateKey, keyPair.privateKey)
        && Objects.equals(publicKey, keyPair.publicKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(privateKey, publicKey);
  }

  @Override
  public String toString() {
    return "KeyPair{" + privateKey + ", " + publicKey + '}';
  }
}
