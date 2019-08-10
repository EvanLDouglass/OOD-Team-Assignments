package edu.neu.khoury.cs5004.assignment9.rsa;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Generates keys for the RSA encryption algorithm.
 */
public class RsaKeyGenerator {

  private Integer primeBitLength;

  /**
   * Constructor for {@code RsaKeyGenerator}.
   *
   * @param primeBitLength the length in bits of desired prime numbers
   */
  public RsaKeyGenerator(Integer primeBitLength) {
    this.primeBitLength = primeBitLength;
  }

  /* ===== Methods ===== */

  /**
   * Generates a random Public and Private RSA key pair.
   *
   * @return a KeyPair containing the public and private keys
   */
  public KeyPair generateKeyPair() {
    // Steps from https://en.wikipedia.org/wiki/RSA_(cryptosystem)#Key_generation
    SecureRandom rand = new SecureRandom();
    // Step 1
    BigInteger prime1 = BigInteger.probablePrime(primeBitLength, rand);
    BigInteger prime2 = BigInteger.probablePrime(primeBitLength, rand);
    // Step 2
    BigInteger modulus = prime1.multiply(prime2);
    // Step 3
    BigInteger phiOfModulus = getPhiOfModulus(prime1, prime2);
    // Step 4
    BigInteger secretKeyExponent = getACoPrime(prime1, prime2, rand);
    // Step 5
    BigInteger publicKeyExponent = secretKeyExponent.modInverse(phiOfModulus);
    // Finally, make keys and return a KeyPair
    PublicKey publicKey = new PublicKey(publicKeyExponent, modulus);
    PrivateKey privateKey = new PrivateKey(secretKeyExponent, modulus);
    return new KeyPair(privateKey, publicKey);
  }

  /**
   * The Carmichael's totient function as described on wikipedia at
   * https://en.wikipedia.org/wiki/RSA_(cryptosystem)#Key_generation, represented in the assignment
   * write up as the greek letter phi.
   *
   * @param prime1 a prime generated during the rsa key generation algorithm
   * @param prime2 a prime generated during the rsa key generation algorithm
   * @return the result of phi(prime1 * prime2) == phi(modulus)
   */
  private BigInteger getPhiOfModulus(BigInteger prime1, BigInteger prime2) {
    BigInteger num1, num2;
    BigInteger one = new BigInteger("1");
    num1 = prime1.subtract(one);
    num2 = prime2.subtract(one);
    return lcm(num1, num2);
  }

  /**
   * Provides the least common multiple algorithm for two big integers.
   *
   * @param num1 first number
   * @param num2 second number
   * @return the least common multiple of the two given numbers
   */
  private BigInteger lcm(BigInteger num1, BigInteger num2) {
    // Multiply the numbers
    BigInteger mult = num1.multiply(num2);
    // Get the gcd of the numbers
    BigInteger gcd = num1.gcd(num2);
    // Divide to find lcm
    return mult.divide(gcd);
  }

  /**
   * Produces a verified coPrime to the product of the two given primes
   *
   * @param prime1 a prime number
   * @param prime2 a prime number
   * @param rand a random number generator
   * @return a co-prime to prime1*prime2 and phi(prime1*prime2)
   */
  private BigInteger getACoPrime(BigInteger prime1, BigInteger prime2, Random rand) {
    BigInteger coPrime = BigInteger.probablePrime(primeBitLength, rand);
    // Test to ensure is coPrime
    BigInteger lcmMod = coPrime.gcd(prime1.multiply(prime2));
    BigInteger lcmPhiOfMod = coPrime.gcd(getPhiOfModulus(prime1, prime2));
    while (lcmMod.intValueExact() != 1 && lcmPhiOfMod.intValueExact() != 1) {
      // Keep getting coPrimes until verified
      coPrime = BigInteger.probablePrime(primeBitLength, rand);
      lcmMod = coPrime.gcd(prime1.multiply(prime2));
      lcmPhiOfMod = coPrime.gcd(getPhiOfModulus(prime1, prime2));
    }
    return coPrime;
  }
}
