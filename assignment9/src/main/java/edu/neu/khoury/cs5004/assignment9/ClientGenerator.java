package edu.neu.khoury.cs5004.assignment9;

import edu.neu.khoury.cs5004.assignment9.client.Client;
import java.util.ArrayList;
import java.util.List;

/**
 * Used to generate collections of {@code Client}s. Currently only generates a {@code List}.
 */
public class ClientGenerator {

  public static List<Client> makeList(Integer numClients) {
    List<Client> list = new ArrayList<>(numClients);
    for (int i = 0; i < numClients; i++) {
      list.add(new Client());
    }
    return list;
  }

}
