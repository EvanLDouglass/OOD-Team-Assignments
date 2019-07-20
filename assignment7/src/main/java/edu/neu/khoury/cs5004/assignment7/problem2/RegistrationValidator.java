package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.HashSet;
import java.util.Objects;

/**
 * The type Registration validator.
 */
public class RegistrationValidator {
  private static final int AGE_LIMITATION = 21;
  private static final int MONTH_LIMITATION = 6;
  private static final int VEHICLE_YEAR = 20;
  private HashSet<Driver> driversPool;

  /**
   * Instantiates a new Registration validator.
   *
   * @param driver the driver
   */
  public RegistrationValidator(Driver driver, HashSet<Driver> driversPool) {
    this.driversPool = driversPool;
    if (checkAge(driver) && checkLicnese(driver)
        && checkVehicleInfo(driver)
        && checkVehicleInsuranceInfo(driver)
        && checkDriverHistory(driver)
        && checkVehicleHistory(driver)) {
      this.driversPool.add(driver);
    }
  }

  private boolean checkAge(Driver driver) {
    if (driver.getDriverBirthday().getYearDuration() < AGE_LIMITATION) {
      return false;
    }
    return true;
  }

  private boolean checkLicnese(Driver driver) {
    if (driver.getDriverName().equals(driver.getDriverLicenseInformation().getDriverName())
        &&
        driver.getDriverBirthday().equals(driver.getDriverLicenseInformation().getDriverBirthdate())
        &&
        driver.getDriverLicenseInformation().getCuntryOrStateOfIssuance() == "US"
        &&
        driver.getDriverLicenseInformation().getIssuanceDate().getMonthDuration() > MONTH_LIMITATION
        &&
        driver.getDriverLicenseInformation().getExpirationDate().getDayDuration() < 0) {
      return true;
    }
    return false;
  }

  private boolean checkVehicleInfo(Driver driver) {
    if (driver.getVehicleInformation().getYear().getYearDuration() > VEHICLE_YEAR) {
      return false;
    }
    return true;
  }

  private boolean checkVehicleInsuranceInfo(Driver driver) {
    if ((driver.getVehicleInformation().getOfficialOwner().equals(driver.getDriverName())
        || driver.getVehicleInsuranceInformation().getPeopleCoverd()
        .contains(driver.getDriverName()))
        && driver.getVehicleInsuranceInformation().getExpirationDate().getDayDuration() < 0) {
      return true;
    }
    return false;
  }

  private boolean checkDriverHistory(Driver driver) {
    for (DriverViolation temp : driver.getDriverHistory().getViolations()) {
      if (temp.equals(MovingViolation.RECKLESSDRIVING)
          || temp.equals(MovingViolation.SPEEDING)
          || temp.equals(MovingViolation.DRIVINGNUMBERINFLUENCE)
          || temp.equals(MovingViolation.DRIVINGWITHOUTAVALIDLICENSEANDORINSURANCE)) {
        return false;
      }
    }
    return true;
  }

  private boolean checkVehicleHistory(Driver driver) {
    for (VehicleViolation temp : driver.getVehicleHistory().getVehicleViolations()) {
      if (temp.getOffendingDate().getMonthDuration() < MONTH_LIMITATION) {
        return false;
      }
    }
    for (VehicleCrash temp : driver.getVehicleHistory().getCrashes()) {
      if (temp.getOffendingDate().getMonthDuration() < MONTH_LIMITATION) {
        return false;
      }
    }
    return true;
  }

  /**
   * Gets drivers pool.
   *
   * @return the drivers pool
   */
  public HashSet<Driver> getDriversPool() {
    return this.driversPool;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    RegistrationValidator that = (RegistrationValidator) other;
    return Objects.equals(driversPool, that.driversPool);
  }

  @Override
  public int hashCode() {
    return Objects.hash(driversPool);
  }

  @Override
  public String toString() {
    return "RegistrationValidator{"
        +
        "driversPool="
        + driversPool
        +
        '}';
  }
}
