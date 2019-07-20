package edu.neu.khoury.cs5004.assignment7.problem1;

import com.sun.javaws.exceptions.InvalidArgumentException;
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

  /**
   * Ensures that the absolute value of a given integer has the same number of digits as given by
   * {@code length}.
   *
   * @param num the integer to test
   * @param length the number of digits num should have
   * @throws InvalidArgumentException if the absolute value of the given integer does not have the
   *     number of digits given by length
   */
  public static void validateIntegerLength(Integer num, Integer length)
      throws InvalidArgumentException {
    String str = Integer.toString(Math.abs(num));
    if (str.length() != length) {
      String msg = "Integer " + num + ": expected " + length + " digits.";
      throw new InvalidArgumentException(new String[]{msg});
    }
  }
}
