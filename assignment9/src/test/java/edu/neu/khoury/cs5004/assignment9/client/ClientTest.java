package edu.neu.khoury.cs5004.assignment9.client;

import static org.junit.Assert.*;

import edu.neu.khoury.cs5004.assignment9.rsa.MsgSigPair;
import edu.neu.khoury.cs5004.assignment9.rsa.PublicKey;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

// Need fixed order due to static incrementer. getId returns failed if it is not run before
// getPublicKey
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientTest {

  private final Client client = new Client();

  @Test
  public void requestTransaction() {
    MsgSigPair pair = client.requestTransaction(1000);
    assertEquals(1000, (int) pair.getMessage());
  }

  @Test
  public void getId() {
    assertEquals(0L, (long) client.getId());

    Client nextClient = new Client();
    assertEquals(1L, (long) nextClient.getId());

    nextClient = new Client();
    assertEquals(2L, (long) nextClient.getId());

    nextClient = new Client();
    assertEquals(3L, (long) nextClient.getId());

    nextClient = new Client();
    assertEquals(4L, (long) nextClient.getId());

    nextClient = new Client();
    assertEquals(5L, (long) nextClient.getId());
  }

  @Test
  public void getPublicKey() {
    // Public key is randomly generated, so long as it is the same for every call,
    // and different for different clients, that is an acceptable test
    PublicKey key = client.getPublicKey();
    PublicKey key1 = client.getPublicKey();
    assertEquals(key, key1);

    Client nextClient = new Client();
    key1 = nextClient.getPublicKey();
    assertNotEquals(key1, key);
  }
}