package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

/**
 * The type Driver.
 */
public class Driver {
  private Name driverName;
  private Date driverBirthday;
  private License driverLicenseInformation;
  private VehicleInfo vehicleInformation;
  private VehicleInsuranceInfo vehicleInsuranceInformation;
  private DriverHistory driverHistory;
  private VehicleHistory vehicleHistory;

  /**
   * Instantiates a new Driver.
   *
   * @param driverName the driver name
   * @param driverBirthday the driver birthday
   * @param driverLicenseInformation the driver license information
   * @param vehicleInformation the vehicle information
   * @param vehicleInsuranceInformation the vehicle insurance information
   * @param driverHistory the driver history
   * @param vehicleHistory the vehicle history
   */
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

  /**
   * Gets driver name.
   *
   * @return the driver name
   */
  public Name getDriverName() {
    return driverName;
  }

  /**
   * Gets driver birthday.
   *
   * @return the driver birthday
   */
  public Date getDriverBirthday() {
    return driverBirthday;
  }

  /**
   * Gets driver license information.
   *
   * @return the driver license information
   */
  public License getDriverLicenseInformation() {
    return driverLicenseInformation;
  }

  /**
   * Gets vehicle information.
   *
   * @return the vehicle information
   */
  public VehicleInfo getVehicleInformation() {
    return vehicleInformation;
  }

  /**
   * Gets vehicle insurance information.
   *
   * @return the vehicle insurance information
   */
  public VehicleInsuranceInfo getVehicleInsuranceInformation() {
    return vehicleInsuranceInformation;
  }

  /**
   * Gets driver history.
   *
   * @return the driver history
   */
  public DriverHistory getDriverHistory() {
    return driverHistory;
  }

  /**
   * Gets vehicle history.
   *
   * @return the vehicle history
   */
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
