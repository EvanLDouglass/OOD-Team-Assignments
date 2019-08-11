package edu.neu.khoury.cs5004.assignment9;

import edu.neu.khoury.cs5004.assignment9.bank.Bank;
import edu.neu.khoury.cs5004.assignment9.bank.BankClientTracker;
import edu.neu.khoury.cs5004.assignment9.client.Client;
import edu.neu.khoury.cs5004.assignment9.rsa.MsgSigPair;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Main class.
 */
public class SecureBankVerificationSimulator {

  private static final int CERTAIN = 100;  // %

  private static Random rand = new SecureRandom();

  /**
   * The main method.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    // Validate and store arguments
    ArgsValidator validator = new ArgsValidator();
    validator.processArguments(args);

    // Open CSV first, in case of failure
    CsvWriter out = openFile(validator);

    // Make list of clients
    Integer numClients = validator.getNumberOfClients();
    List<Client> clientList = ClientGenerator.makeList(numClients);

    // Make bank with client trackers
    Bank bank = makeBank(clientList);

    // Proceed with verifications
    Integer numVers = validator.getNumberOfVerification();
    Integer percentInvalid = validator.getPercentageOfInvalidMessage();
    for (long i = 0; i < numVers; i++) {
      // Pick random message
      Integer message = SimulatorRandom.generateMessage();

      // Pick client for transaction
      int clientIndex = rand.nextInt(numClients);  // [0, numClients)
      Client client = clientList.get(clientIndex);

      // Pick signature based on % invalid
      // Make message-signature pair
      MsgSigPair msgSigPair = chooseMsgSig(percentInvalid, message, client);

      // Get Bank's client info and verify the signature
      BankClientTracker tracker = bank.getClientInfo(client.getId());
      // RSA verification
      boolean verified = bank.verifyMsgSigPair(msgSigPair, tracker.getPublicKey());
      // Check if transaction is in limits
      // This will cause the actual invalid percentage to be greater than specified
      if (!bank.transactionInLimits(client.getId(), message)) {
        verified = false;
      }

      // Record transaction
      Date now = new Date();
      try {
        out.writeLine(i, now, client.getId(), message, msgSigPair.getSignature(), verified);
      } catch (IOException e) {
        System.out.println("Problem with output file initialization. Transaction skipped.");
        System.out.println(e.getMessage());
      }
    }
    // Done with transactions, close file
    closeFile(out);
    // Success message
    System.out.println("Transactions successfully recorded.");
  }

  /**
   * Creates a bank with the given clients.
   *
   * @param clients a list of clients
   * @return a bank with the given clients
   */
  private static Bank makeBank(List<Client> clients) {
    Bank bank = new Bank(new HashMap<>());
    for (Client client : clients) {
      // Make random limits
      Integer withdrawLimit = SimulatorRandom.generateWithdrawLimit();
      Integer depositLimit = SimulatorRandom.generateDepositLimit();
      // Make tracker
      BankClientTracker tracker = new BankClientTracker(client.getPublicKey(), depositLimit,
          withdrawLimit);
      // Add to map
      bank.getIdTracker().put(client.getId(), tracker);
    }
    return bank;
  }

  /**
   * Produces a message-signature pair that is either valid or random (invalid).
   *
   * @param percentInvalid the percentage of MsgSigPairs that should have random signatures
   * @param message a message to use
   * @param client the client requesting this transaction
   * @return a MsgSigPair
   */
  private static MsgSigPair chooseMsgSig(Integer percentInvalid, Integer message, Client client) {
    MsgSigPair msgSigPair;
    int choice = rand.nextInt(CERTAIN + 1);  // [0, 100]
    if (choice < percentInvalid) {
      // Invalid/Random signature
      int sig = rand.nextInt(Integer.MAX_VALUE);
      msgSigPair = new MsgSigPair(message, new BigInteger(Integer.toString(sig)));
    } else {
      msgSigPair = client.requestTransaction(message);
    }
    return msgSigPair;
  }

  /**
   * Inits a CsvWriter after checking for errors. If errors are found, exits program.
   *
   * @param validator an ArgsValidator
   */
  private static CsvWriter openFile(ArgsValidator validator) {
    CsvWriter writer = null;
    try {
      writer = new CsvWriter(validator.getOutputFile());
    } catch (IOException e) {
      System.out.println("Problem with output file initialization.");
      System.out.println(e.getMessage());
      System.exit(1);
    }
    return writer;
  }

  /**
   * Closes a file after checking for errors. If errors are found, exits program.
   *
   * @param writer a CsvWriter to close
   */
  private static void closeFile(CsvWriter writer) {
    try {
      writer.closeCsv();
    } catch (IOException e) {
      System.out.println("Problem closing file.");
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }
}
