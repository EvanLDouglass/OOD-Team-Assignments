package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

/**
 * The type Driver violation.
 */
public class DriverViolation {
  private MovingViolation movingViolation;
  private NonMovingViolation nonMovingViolation;


  /**
   * Instantiates a new Driver violation.
   *
   * @param movingViolation the moving violation
   */
  public DriverViolation(MovingViolation movingViolation) {
    this.movingViolation = movingViolation;
  }

  /**
   * Instantiates a new Driver violation.
   *
   * @param nonMovingViolation the non moving violation
   */
  public DriverViolation(NonMovingViolation nonMovingViolation) {
    this.nonMovingViolation = nonMovingViolation;
  }

  /**
   * Gets moving violation.
   *
   * @return the moving violation
   */
  public MovingViolation getMovingViolation() {
    return movingViolation;
  }

  /**
   * Gets non moving violation.
   *
   * @return the non moving violation
   */
  public NonMovingViolation getNonMovingViolation() {
    return nonMovingViolation;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    DriverViolation that = (DriverViolation) other;
    return movingViolation == that.movingViolation
        &&
        nonMovingViolation == that.nonMovingViolation;
  }

  @Override
  public int hashCode() {
    return Objects.hash(movingViolation, nonMovingViolation);
  }

  @Override
  public String toString() {
    return "DriverViolation{"
        +
        "movingViolation="
        + movingViolation
        +
        ", nonMovingViolation="
        + nonMovingViolation
        +
        '}';
  }
}
