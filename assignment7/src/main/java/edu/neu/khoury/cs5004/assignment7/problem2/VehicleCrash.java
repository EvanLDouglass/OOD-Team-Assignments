package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.HashSet;
import java.util.Objects;

public class VehicleCrash {
  private Name offendingDriver;
  private Date offendingDate;
  private Crash crash;

  public VehicleCrash(Name offendingDriver,
      Date offendingDate, Crash crash) {
    this.offendingDriver = offendingDriver;
    this.offendingDate = offendingDate;
    this.crash = crash;
  }

  public Name getOffendingDriver() {
    return offendingDriver;
  }

  public Date getOffendingDate() {
    return offendingDate;
  }

  public Crash getCrash() {
    return crash;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleCrash that = (VehicleCrash) o;
    return Objects.equals(offendingDriver, that.offendingDriver) &&
        Objects.equals(offendingDate, that.offendingDate) &&
        crash == that.crash;
  }

  @Override
  public int hashCode() {
    return Objects.hash(offendingDriver, offendingDate, crash);
  }

  @Override
  public String toString() {
    return "VehicleCrash{" +
        "offendingDriver=" + offendingDriver +
        ", offendingDate=" + offendingDate +
        ", crash=" + crash +
        '}';
  }
}
