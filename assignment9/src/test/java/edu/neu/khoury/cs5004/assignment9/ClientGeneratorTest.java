package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;

import edu.neu.khoury.cs5004.assignment9.client.Client;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ClientGeneratorTest {

  private List<Client> list;

  @Before
  public void setUp() throws Exception {
    list = ClientGenerator.makeList(5);
  }

  @Test
  public void checkSize() {
    assertEquals(5, list.size());
  }

  @Test
  public void checkIds() {
    assertNotEquals(list.get(0).getId(), list.get(1).getId());
    assertNotEquals(list.get(1).getId(), list.get(2).getId());
    assertNotEquals(list.get(2).getId(), list.get(3).getId());
    assertNotEquals(list.get(3).getId(), list.get(4).getId());
  }

  @Test
  public void checkPublicKeys() {
    assertNotEquals(list.get(0).getPublicKey(), list.get(1).getPublicKey());
    assertNotEquals(list.get(1).getPublicKey(), list.get(2).getPublicKey());
    assertNotEquals(list.get(2).getPublicKey(), list.get(3).getPublicKey());
    assertNotEquals(list.get(3).getPublicKey(), list.get(4).getPublicKey());
  }
}