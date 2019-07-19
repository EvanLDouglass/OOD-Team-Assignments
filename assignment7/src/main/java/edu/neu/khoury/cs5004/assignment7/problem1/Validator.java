package edu.neu.khoury.cs5004.assignment7.problem1;

import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.NullObjectException;

/**
 * Provides some common validation methods.
 *
 * @author evandouglass
 */
public class Validator {

  /**
   * Ensures that a given object is not null.
   *
   * @param obj an object to test
   * @param message a message to include in the exception if thrown
   * @throws NullObjectException if the given object is null
   */
  public static void validateNotNull(Object obj, String message) throws NullObjectException {
    if (obj == null) {
      throw new NullObjectException(message);
    }
  }
}
