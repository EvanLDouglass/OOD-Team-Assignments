package edu.neu.khoury.cs5004.assignment9;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * The type Args validator.validate the four arguments, each have some requirements
 * and the length must be 4, the order can't be changed
 */
public class ArgsValidator {

  private static final int ARGS_LENGTH = 4;
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
  public void processArgument(String[] args) throws InvalidArgumentException{
    checkArgLengh(args);
    List<String> arglist = Arrays.asList(args);
    if (arglist.get(0) != null
        && arglist.get(1) != null
        && arglist.get(2) != null
        && arglist.get(3) != null) {
      Integer argument1 = Integer.valueOf(arglist.get(0));
      Integer argument2 = Integer.valueOf(arglist.get(1));
      Integer argument3 = Integer.valueOf(arglist.get(2));
      if (argument1 <= 50000
          && argument2 <= 1000
          && argument3 <= 100
          && argument3 >= 0) {
        this.numberOfClients = argument1;
        this.numberOfVerification = argument2;
        this.percentageOfInvalidMessage = argument3;
        this.outputFile = arglist.get(3);
      } else {
        throw new InvalidArgumentException("error: invalid arguments");
      }
    }
  }


  /**
   * Check arg lengh.
   *
   * @param args the args
   * @throws InvalidArgumentException the invalid argument exception
   */
  public void checkArgLengh(String[] args) throws InvalidArgumentException {
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

