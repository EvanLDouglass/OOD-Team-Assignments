package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

/**
 * The type Vehicle crash.
 */
public class VehicleCrash {
  private Name offendingDriver;
  private Date offendingDate;
  private Crash crash;

  /**
   * Instantiates a new Vehicle crash.
   *
   * @param offendingDriver the offending driver
   * @param offendingDate the offending date
   * @param crash the crash
   */
  public VehicleCrash(Name offendingDriver,
      Date offendingDate, Crash crash) {
    this.offendingDriver = offendingDriver;
    this.offendingDate = offendingDate;
    this.crash = crash;
  }

  /**
   * Gets offending driver.
   *
   * @return the offending driver
   */
  public Name getOffendingDriver() {
    return offendingDriver;
  }

  /**
   * Gets offending date.
   *
   * @return the offending date
   */
  public Date getOffendingDate() {
    return offendingDate;
  }

  /**
   * Gets crash.
   *
   * @return the crash
   */
  public Crash getCrash() {
    return crash;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    VehicleCrash that = (VehicleCrash) other;
    return Objects.equals(offendingDriver, that.offendingDriver)
        &&
        Objects.equals(offendingDate, that.offendingDate)
        &&
        crash == that.crash;
  }

  @Override
  public int hashCode() {
    return Objects.hash(offendingDriver, offendingDate, crash);
  }

  @Override
  public String toString() {
    return "VehicleCrash{"
        +
        "offendingDriver="
        + offendingDriver
        +
        ", offendingDate="
        + offendingDate
        +
        ", crash="
        + crash
        +
        '}';
  }
}
