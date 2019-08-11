package edu.neu.khoury.cs5004.assignment9;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Generates random messages for the secure bank simulator.
 */
public class SimulatorRandom {

  private static final int MAX_MSG = 30001;
  private static final int MAX_WITHDRAW = 3001;
  private static final int MAX_DEPOSIT = 2001;

  private static Random random = new SecureRandom();

  /**
   * Generate message integer.
   *
   * @return the integer
   */
  public static Integer generateMessage() {
    return random.nextInt(MAX_MSG);
  }

  public static Integer generateWithdrawLimit() {
    return random.nextInt(MAX_WITHDRAW);
  }

  public static Integer generateDepositLimit() {
    return random.nextInt(MAX_DEPOSIT);
  }
}
