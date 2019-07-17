package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

/**
 * The type Vehicle violation.
 */
public class VehicleViolation extends DriverViolation {
  private Name offendingDriver;
  private Date offendingDate;

  /**
   * Instantiates a new Vehicle violation.
   *
   * @param movingViolation the moving violation
   * @param offendingDriver the offending driver
   * @param offendingDate the offending date
   */
  public VehicleViolation(MovingViolation movingViolation,
      Name offendingDriver, Date offendingDate) {
    super(movingViolation);
    this.offendingDriver = offendingDriver;
    this.offendingDate = offendingDate;
  }

  /**
   * Instantiates a new Vehicle violation.
   *
   * @param nonMovingViolation the non moving violation
   * @param offendingDriver the offending driver
   * @param offendingDate the offending date
   */
  public VehicleViolation(
      NonMovingViolation nonMovingViolation,
      Name offendingDriver, Date offendingDate) {
    super(nonMovingViolation);
    this.offendingDriver = offendingDriver;
    this.offendingDate = offendingDate;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    VehicleViolation that = (VehicleViolation) o;
    return Objects.equals(offendingDriver, that.offendingDriver) &&
        Objects.equals(offendingDate, that.offendingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), offendingDriver, offendingDate);
  }

  @Override
  public String toString() {
    return "VehicleViolation{" +
        "offendingDriver=" + offendingDriver +
        ", offendingDate=" + offendingDate +
        '}';
  }
}
