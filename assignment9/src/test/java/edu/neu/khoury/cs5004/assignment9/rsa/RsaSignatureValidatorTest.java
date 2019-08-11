package edu.neu.khoury.cs5004.assignment9.rsa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

// This class tests all of the RSA algorithm classes together, as the other parts are necessary
// for validating.
public class RsaSignatureValidatorTest {

  private final RsaKeyGenerator generator = new RsaKeyGenerator(512);
  private final KeyPair keyPair = generator.generateKeyPair();
  private MsgSigPair msgSigPair;

  @Test
  public void validateTrue() {
    msgSigPair = new MsgSigPair(1000,
        RsaSignatureGenerator.signature(1000, keyPair.getPrivateKey()));
    assertTrue(RsaSignatureValidator.validate(msgSigPair, keyPair.getPublicKey()));
  }

  @Test
  public void validateFalse() {
    msgSigPair = new MsgSigPair(1000,
        RsaSignatureGenerator.signature(1500, keyPair.getPrivateKey()));
    assertFalse(RsaSignatureValidator.validate(msgSigPair, keyPair.getPublicKey()));
  }
}