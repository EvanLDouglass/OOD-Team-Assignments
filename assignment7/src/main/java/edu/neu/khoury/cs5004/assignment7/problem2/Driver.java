package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

public class Driver {
  private Name driverName;
  private Date driverBirthday;
  private License driverLicenseInformation;
  private VehicleInfo vehicleInformation;
  private VehicleInsuranceInfo vehicleInsuranceInformation;
  private DriverHistory driverHistory;
  private VehicleHistory vehicleHistory;

  public Driver(Name driverName, Date driverBirthday,
      License driverLicenseInformation,
      VehicleInfo vehicleInformation,
      VehicleInsuranceInfo vehicleInsuranceInformation,
      DriverHistory driverHistory,
      VehicleHistory vehicleHistory) {
    this.driverName = driverName;
    this.driverBirthday = driverBirthday;
    this.driverLicenseInformation = driverLicenseInformation;
    this.vehicleInformation = vehicleInformation;
    this.vehicleInsuranceInformation = vehicleInsuranceInformation;
    this.driverHistory = driverHistory;
    this.vehicleHistory = vehicleHistory;
  }

  public Name getDriverName() {
    return driverName;
  }

  public Date getDriverBirthday() {
    return driverBirthday;
  }

  public License getDriverLicenseInformation() {
    return driverLicenseInformation;
  }

  public VehicleInfo getVehicleInformation() {
    return vehicleInformation;
  }

  public VehicleInsuranceInfo getVehicleInsuranceInformation() {
    return vehicleInsuranceInformation;
  }

  public DriverHistory getDriverHistory() {
    return driverHistory;
  }

  public VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Driver driver = (Driver) o;
    return Objects.equals(driverName, driver.driverName) &&
        Objects.equals(driverBirthday, driver.driverBirthday) &&
        Objects.equals(driverLicenseInformation, driver.driverLicenseInformation) &&
        Objects.equals(vehicleInformation, driver.vehicleInformation) &&
        Objects.equals(vehicleInsuranceInformation, driver.vehicleInsuranceInformation) &&
        Objects.equals(driverHistory, driver.driverHistory) &&
        Objects.equals(vehicleHistory, driver.vehicleHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(driverName, driverBirthday, driverLicenseInformation, vehicleInformation,
        vehicleInsuranceInformation, driverHistory, vehicleHistory);
  }

  @Override
  public String toString() {
    return "Driver{" +
        "driverName=" + driverName +
        ", driverBirthday=" + driverBirthday +
        ", driverLicenseInformation=" + driverLicenseInformation +
        ", vehicleInformation=" + vehicleInformation +
        ", vehicleInsuranceInformation=" + vehicleInsuranceInformation +
        ", driverHistory=" + driverHistory +
        ", vehicleHistory=" + vehicleHistory +
        '}';
  }
}
