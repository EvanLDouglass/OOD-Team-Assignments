package edu.neu.khoury.cs5004.assignment9;

import edu.neu.khoury.cs5004.assignment9.bank.Bank;
import edu.neu.khoury.cs5004.assignment9.bank.BankClientTracker;
import edu.neu.khoury.cs5004.assignment9.client.Client;
import java.util.HashMap;
import java.util.List;

/**
 * Main class.
 */
public class SecureBankVerificationSimulator
{
    public static void main( String[] args )
    {
        // Validate and store arguments
        ArgsValidator validator = new ArgsValidator();
        validator.processArguments(args);

        // Make list of clients
        List<Client> clientList = ClientGenerator.makeList(validator.getNumberOfClients());

        // Make bank with client trackers
        Bank bank = new Bank(new HashMap<>());
        for (Client client : clientList) {
            // Make random limits
            Integer withdrawLimit = SimulatorRandom.generateWithdrawLimit();
            Integer depositLimit = SimulatorRandom.generateDepositLimit();
            // Make tracker
            BankClientTracker tracker = new BankClientTracker(client.getPublicKey(), depositLimit,
                withdrawLimit);
            // Add to map
            bank.getIdTracker().put(client.getId(), tracker);
        }

        // TODO: Make transactions and output to file
    }
}
