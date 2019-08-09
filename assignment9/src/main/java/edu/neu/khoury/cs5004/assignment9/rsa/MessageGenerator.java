package edu.neu.khoury.cs5004.assignment9.rsa;

import java.util.Random;

/**
 * The type Message generator.
 */
public class MessageGenerator {
  private static final int MAX_NUMBER = 3000;

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
