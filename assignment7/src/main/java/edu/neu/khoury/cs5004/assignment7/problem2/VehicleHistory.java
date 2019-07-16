package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.HashSet;
import java.util.Objects;

public class VehicleHistory {
 private HashSet<VehicleCrash> crashes;
 private HashSet<VehicleViolation> vehicleViolations;

  public VehicleHistory(
      HashSet<VehicleCrash> crashes,
      HashSet<VehicleViolation> vehicleViolations) {
    this.crashes = crashes;
    this.vehicleViolations = vehicleViolations;
  }

  public HashSet<VehicleCrash> getCrashes() {
    return crashes;
  }

  public HashSet<VehicleViolation> getVehicleViolations() {
    return vehicleViolations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleHistory that = (VehicleHistory) o;
    return Objects.equals(crashes, that.crashes) &&
        Objects.equals(vehicleViolations, that.vehicleViolations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crashes, vehicleViolations);
  }

  @Override
  public String toString() {
    return "VehicleHistory{" +
        "crashes=" + crashes +
        ", vehicleViolations=" + vehicleViolations +
        '}';
  }
}
