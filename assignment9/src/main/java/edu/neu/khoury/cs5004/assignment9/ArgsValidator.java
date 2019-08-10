package edu.neu.khoury.cs5004.assignment9;

import java.util.Arrays;
import java.util.List;

/**
 * The type Args validator. Validate the four arguments, each have some requirements
 * and the length must be 4, the order can't be changed.
 */
public class ArgsValidator {

  private static final int ARGS_LENGTH = 4;
  private static final int MAX_CLIENTS = 50000;
  private static final int MAX_VERIFICATIONS = 10000;
  private static final int MAX_PERCENT = 100;

  private Integer numberOfClients;
  private Integer numberOfVerification;
  private Integer percentageOfInvalidMessage;
  private String outputFile;

  /**
   * Instantiates a new Args validator.
   */
  public ArgsValidator() {
    this.numberOfClients = 0;
    this.numberOfVerification = 0;
    this.percentageOfInvalidMessage = 0;
    this.outputFile = null;
  }

  /**
   * Process argument.
   *
   * @param args the args
   * @throws InvalidArgumentException the invalid argument exception
   */
  public void processArguments(String[] args) throws InvalidArgumentException{
    checkArgLength(args);
    List<String> arglist = Arrays.asList(args);
    if (arglist.get(0) != null
        && arglist.get(1) != null
        && arglist.get(2) != null
        && arglist.get(3) != null) {
      Integer argument1 = Integer.valueOf(arglist.get(0));
      Integer argument2 = Integer.valueOf(arglist.get(1));
      Integer argument3 = Integer.valueOf(arglist.get(2));
      if (argument1 <= MAX_CLIENTS
          && argument2 <= MAX_VERIFICATIONS
          && argument3 <= MAX_PERCENT
          && argument3 >= 0) {
        this.numberOfClients = argument1;
        this.numberOfVerification = argument2;
        this.percentageOfInvalidMessage = argument3;
        this.outputFile = arglist.get(3);
      } else {
        throw new InvalidArgumentException("error: invalid arguments");
      }
    } else {
      throw new InvalidArgumentException("error: args can't be null");
    }
  }

  /**
   * Check arg length.
   *
   * @param args the args
   * @throws InvalidArgumentException the invalid argument exception
   */
  public void checkArgLength(String[] args) throws InvalidArgumentException {
    if (args.length != ARGS_LENGTH) {
      throw new InvalidArgumentException("Error:invalid argument length");
    }
  }

  /**
   * Gets number of clients.
   *
   * @return the number of clients
   */
  public Integer getNumberOfClients() {
    return numberOfClients;
  }

  /**
   * Gets number of verification.
   *
   * @return the number of verification
   */
  public Integer getNumberOfVerification() {
    return numberOfVerification;
  }

  /**
   * Gets percentage of invalid message.
   *
   * @return the percentage of invalid message
   */
  public Integer getPercentageOfInvalidMessage() {
    return percentageOfInvalidMessage;
  }

  /**
   * Gets output file.
   *
   * @return the output file
   */
  public String getOutputFile() {
    return outputFile;
  }
}

