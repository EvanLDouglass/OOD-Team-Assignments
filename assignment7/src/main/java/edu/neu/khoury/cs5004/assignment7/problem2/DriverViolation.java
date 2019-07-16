package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

public class DriverViolation {
  private MovingViolation movingViolation;
  private NonMovingViolation nonMovingViolation;


  public DriverViolation(MovingViolation movingViolation) {
    this.movingViolation = movingViolation;
  }

  public DriverViolation(NonMovingViolation nonMovingViolation) {
    this.nonMovingViolation = nonMovingViolation;
  }

  public MovingViolation getMovingViolation() {
    return movingViolation;
  }

  public NonMovingViolation getNonMovingViolation() {
    return nonMovingViolation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DriverViolation that = (DriverViolation) o;
    return movingViolation == that.movingViolation &&
        nonMovingViolation == that.nonMovingViolation;
  }

  @Override
  public int hashCode() {
    return Objects.hash(movingViolation, nonMovingViolation);
  }

  @Override
  public String toString() {
    return "DriverViolation{" +
        "movingViolation=" + movingViolation +
        ", nonMovingViolation=" + nonMovingViolation +
        '}';
  }
}
