package edu.neu.khoury.cs5004.assignment9.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.khoury.cs5004.assignment9.client.Client;
import edu.neu.khoury.cs5004.assignment9.rsa.MsgSigPair;
import edu.neu.khoury.cs5004.assignment9.rsa.PublicKey;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

  private Bank bank;
  private Map<Long, BankClientTracker> idTracker;
  private PublicKey publicKey;
  private BankClientTracker bankClientTracker;


  @Before
  public void setUp() throws Exception {
    this.idTracker = new HashMap<>();
    this.publicKey = new PublicKey(new BigInteger("1234567890"), new BigInteger("9876543210"));
    this.bankClientTracker = new BankClientTracker(publicKey, 1000, 1000);
    this.idTracker.put((long) 33725807, this.bankClientTracker);
    this.bank = new Bank(this.idTracker);
  }

  @Test
  public void getIdTracker() {
    assertEquals(this.idTracker, bank.getIdTracker());
  }


  @Test
  public void getClientInfo() {
    assertEquals(this.bankClientTracker, bank.getClientInfo((long) 33725807));

  }

  @Test
  public void equals1() {
    Bank anotherBank = new Bank(this.idTracker);
    assertTrue(this.bank.equals(this.bank));
    assertFalse(this.bank.equals(null));
    assertFalse(this.bank.equals(1));
    assertTrue(this.bank.equals(anotherBank));

    anotherBank = new Bank(new HashMap<>());
    assertFalse(bank.equals(anotherBank));
  }

  @Test
  public void hashCode1() {
    Bank anotherBank = new Bank(this.idTracker);
    assertEquals(anotherBank.hashCode(), bank.hashCode());
    assertEquals(bank.hashCode(), bank.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals(
        "Bank{idTracker={33725807=BankClientTracker{publicKey=PublicKey{exponent=1234567890,"
            + " modulus=9876543210}, depositLimit=1000, withdrawLimit=1000}}}",
        this.bank.toString());
  }

  @Test
  public void verifyMsgSigPair() {
    Client client = new Client();
    BankClientTracker tracker = new BankClientTracker(client.getPublicKey(), 10000, 30000);
    Map<Long, BankClientTracker> map = new HashMap<>();
    map.put(client.getId(), tracker);
    bank = new Bank(map);

    Integer msg = 1000;
    MsgSigPair pair = client.requestTransaction(msg);
    assertTrue(bank.verifyMsgSigPair(pair, tracker.getPublicKey()));
  }

  @Test
  public void transactionInLimitsDepositGood() {
    Client client = new Client();
    BankClientTracker tracker = new BankClientTracker(client.getPublicKey(), 10000, 30000);
    Map<Long, BankClientTracker> map = new HashMap<>();
    map.put(client.getId(), tracker);
    bank = new Bank(map);

    Integer msg = 99990;
    assertTrue(bank.transactionInLimits(client.getId(), msg));
    msg = 10;
    assertTrue(bank.transactionInLimits(client.getId(), msg));
  }

  @Test
  public void transactionInLimitsDepositBad() {
    Client client = new Client();
    BankClientTracker tracker = new BankClientTracker(client.getPublicKey(), 10000, 30000);
    Map<Long, BankClientTracker> map = new HashMap<>();
    map.put(client.getId(), tracker);
    bank = new Bank(map);

    Integer msg = 100010;
    assertFalse(bank.transactionInLimits(client.getId(), msg));
    msg = 0;
    assertFalse(bank.transactionInLimits(client.getId(), msg));
  }

  @Test
  public void transactionInLimitsWithdrawalGood() {
    Client client = new Client();
    BankClientTracker tracker = new BankClientTracker(client.getPublicKey(), 10000, 30000);
    Map<Long, BankClientTracker> map = new HashMap<>();
    map.put(client.getId(), tracker);
    bank = new Bank(map);

    Integer msg = 299999;
    assertTrue(bank.transactionInLimits(client.getId(), msg));
    msg = 19;
    assertTrue(bank.transactionInLimits(client.getId(), msg));
  }

  @Test
  public void transactionInLimitsWithdrawalBad() {
    Client client = new Client();
    BankClientTracker tracker = new BankClientTracker(client.getPublicKey(), 10000, 30000);
    Map<Long, BankClientTracker> map = new HashMap<>();
    map.put(client.getId(), tracker);
    bank = new Bank(map);

    Integer msg = 300019;
    assertFalse(bank.transactionInLimits(client.getId(), msg));
    msg = 0;
    assertFalse(bank.transactionInLimits(client.getId(), msg));
  }
}