package edu.neu.khoury.cs5004.assignment9;

import java.util.Random;

/**
 * Generates random messages for the secure bank simulator.
 */
public class MessageGenerator {
  private static final int MAX_NUMBER = 3001;

  /**
   * Generate message integer.
   *
   * @return the integer
   */
  public static Integer generateMessage(){
    Random random = new Random();
    return random.nextInt(MAX_NUMBER);
  }

}
