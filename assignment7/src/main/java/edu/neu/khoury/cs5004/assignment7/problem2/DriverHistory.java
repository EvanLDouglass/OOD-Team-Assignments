package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.HashSet;
import java.util.Objects;

/**
 * The type Driver history.
 */
public class DriverHistory {
  private HashSet<DriverViolation> violations;

  /**
   * Instantiates a new Driver history.
   *
   * @param violations the violations
   */
  public DriverHistory(
      HashSet<DriverViolation> violations) {
    this.violations = violations;
  }

  /**
   * Gets violations.
   *
   * @return the violations
   */
  public HashSet<DriverViolation> getViolations() {
    return violations;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DriverHistory that = (DriverHistory) o;
    return Objects.equals(violations, that.violations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(violations);
  }

  @Override
  public String toString() {
    return "DriverHistory{" +
        "violations=" + violations +
        '}';
  }
}
