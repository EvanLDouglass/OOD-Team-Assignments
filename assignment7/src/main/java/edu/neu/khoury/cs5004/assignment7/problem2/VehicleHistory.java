package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.HashSet;
import java.util.Objects;

/**
 * The type Vehicle history.
 */
public class VehicleHistory {

  private HashSet<VehicleCrash> crashes;
  private HashSet<VehicleViolation> vehicleViolations;

  /**
   * Instantiates a new Vehicle history.
   *
   * @param crashes the crashes
   * @param vehicleViolations the vehicle violations
   */
  public VehicleHistory(
      HashSet<VehicleCrash> crashes,
      HashSet<VehicleViolation> vehicleViolations) {
    this.crashes = crashes;
    this.vehicleViolations = vehicleViolations;
  }

  /**
   * Gets crashes.
   *
   * @return the crashes
   */
  public HashSet<VehicleCrash> getCrashes() {
    return crashes;
  }

  /**
   * Gets vehicle violations.
   *
   * @return the vehicle violations
   */
  public HashSet<VehicleViolation> getVehicleViolations() {
    return vehicleViolations;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    VehicleHistory that = (VehicleHistory) other;
    return Objects.equals(crashes, that.crashes)
        &&
        Objects.equals(vehicleViolations, that.vehicleViolations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crashes, vehicleViolations);
  }

  @Override
  public String toString() {
    return "VehicleHistory{"
        +
        "crashes="
        + crashes
        +
        ", vehicleViolations="
        + vehicleViolations
        +
        '}';
  }
}
