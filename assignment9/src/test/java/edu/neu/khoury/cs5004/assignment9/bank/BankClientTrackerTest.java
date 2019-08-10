package edu.neu.khoury.cs5004.assignment9.bank;

import static org.junit.Assert.*;

import edu.neu.khoury.cs5004.assignment9.rsa.PublicKey;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class BankClientTrackerTest {
  private PublicKey publicKey;
  private BankClientTracker bankClientTracker;

  @Before
  public void setUp() throws Exception {
    publicKey = new PublicKey(new BigInteger("1234567890"), new BigInteger("9876543210"));
    bankClientTracker = new BankClientTracker(publicKey, 1000, 1000);
  }

  @Test
  public void getPublicKey() {
    assertEquals(publicKey, bankClientTracker.getPublicKey());
  }

  @Test
  public void setPublicKey() {
    PublicKey expectedKey = new PublicKey(new BigInteger("9876543210"),
        new BigInteger("1234567890"));
    bankClientTracker.setPublicKey(expectedKey);
    assertEquals(expectedKey, bankClientTracker.getPublicKey());
  }

  @Test
  public void getDepositLimit() {
    assertEquals((Integer) 1000, bankClientTracker.getDepositLimit());
  }

  @Test
  public void setDepositLimit() {
    bankClientTracker.setDepositLimit(2000);
    assertEquals((Integer) 2000, bankClientTracker.getDepositLimit());
  }

  @Test
  public void getWithdrawLimit() {
    assertEquals((Integer)1000, bankClientTracker.getWithdrawLimit());
  }

  @Test
  public void setWithdrawLimit() {
    bankClientTracker.setWithdrawLimit(2000);
    assertEquals((Integer)2000, bankClientTracker.getWithdrawLimit());
  }

  @Test
  public void equals1() {
    PublicKey anotherPubKey = new PublicKey(new BigInteger("1234567890"), new BigInteger("9876543210"));
    BankClientTracker anotherTracker = new BankClientTracker(anotherPubKey, 1000, 1000);
    assertTrue(bankClientTracker.equals(bankClientTracker));
    assertFalse(bankClientTracker.equals(null));
    assertTrue(bankClientTracker.equals(anotherTracker));
  }

  @Test
  public void hashCode1() {
    assertEquals(688400886, bankClientTracker.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals("BankClientTracker{publicKey=PublicKey{exponent=1234567890, modulus=9876543210},"
        + " depositLimit=1000, withdrawLimit=1000}", bankClientTracker.toString());
  }

}