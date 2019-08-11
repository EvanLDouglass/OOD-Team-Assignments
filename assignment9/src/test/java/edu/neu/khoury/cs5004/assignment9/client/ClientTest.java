package edu.neu.khoury.cs5004.assignment9.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import edu.neu.khoury.cs5004.assignment9.rsa.MsgSigPair;
import edu.neu.khoury.cs5004.assignment9.rsa.PublicKey;
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
    Client client1 = new Client();
    Client client2 = new Client();

    assertTrue(client.getClientId() < client1.getClientId());
    assertTrue(client1.getClientId() < client2.getClientId());
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

  @Test
  public void testEquals() {
    // No two clients can be the same, due to id incrementer
    assertEquals(client, client);
  }

  @Test
  public void testNotEquals() {
    assertNotEquals(null, client);
    assertNotEquals(client, null);
    assertNotEquals("String", client);
    assertNotEquals(client, "String");
    assertNotEquals(client, new Client());
    assertNotEquals(new Client(), client);
  }

  @Test
  public void testHashCode() {
    assertEquals(client.hashCode(), client.hashCode());
    assertNotEquals(new Client().hashCode(), client.hashCode());
  }

  @Test
  public void testToString() {
    String regex = "Client\\{id=[0-9]+}";
    System.out.println(client.toString());
    assertTrue(client.toString().matches(regex));
  }
}