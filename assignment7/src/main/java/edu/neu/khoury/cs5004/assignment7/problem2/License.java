package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

/**
 * The type License.
 */
public class License {
  private int licenseNumber;
  private Name driverName;
  private Date driverBirthdate;
  private String cuntryOrStateOfIssuance;
  private Date expirationDate;
  private Date issuanceDate;

  /**
   * Instantiates a new License.
   *
   * @param licenseNumber the license number
   * @param driverName the driver name
   * @param driverBirthdate the driver birthdate
   * @param cuntryOrStateOfIssuance the cuntry or state of issuance
   * @param expirationDate the expiration date
   * @param issuanceDate the issuance date
   */
  public License(int licenseNumber, Name driverName,
      Date driverBirthdate, String cuntryOrStateOfIssuance,
      Date expirationDate, Date issuanceDate) {
    this.licenseNumber = licenseNumber;
    this.driverName = driverName;
    this.driverBirthdate = driverBirthdate;
    this.cuntryOrStateOfIssuance = cuntryOrStateOfIssuance;
    this.expirationDate = expirationDate;
    this.issuanceDate = issuanceDate;
  }

  /**
   * Gets license number.
   *
   * @return the license number
   */
  public int getLicenseNumber() {
    return licenseNumber;
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
   * Gets driver birthdate.
   *
   * @return the driver birthdate
   */
  public Date getDriverBirthdate() {
    return driverBirthdate;
  }

  /**
   * Gets cuntry or state of issuance.
   *
   * @return the cuntry or state of issuance
   */
  public String getCuntryOrStateOfIssuance() {
    return cuntryOrStateOfIssuance;
  }

  /**
   * Gets expiration date.
   *
   * @return the expiration date
   */
  public Date getExpirationDate() {
    return expirationDate;
  }

  /**
   * Gets issuance date.
   *
   * @return the issuance date
   */
  public Date getIssuanceDate() {
    return issuanceDate;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    License license = (License) other;
    return licenseNumber == license.licenseNumber
        &&
        Objects.equals(driverName, license.driverName)
        &&
        Objects.equals(driverBirthdate, license.driverBirthdate)
        &&
        Objects.equals(cuntryOrStateOfIssuance, license.cuntryOrStateOfIssuance)
        &&
        Objects.equals(expirationDate, license.expirationDate)
        &&
        Objects.equals(issuanceDate, license.issuanceDate);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(licenseNumber, driverName, driverBirthdate, cuntryOrStateOfIssuance, expirationDate,
            issuanceDate);
  }

  @Override
  public String toString() {
    return "License{"
        +
        "licenseNumber="
        + licenseNumber
        +
        ", driverName="
        + driverName
        +
        ", driverBirthdate="
        + driverBirthdate
        +
        ", cuntryOrStateOfIssuance='"
        + cuntryOrStateOfIssuance
        + '\''
        +
        ", expirationDate="
        + expirationDate
        +
        ", issuanceDate="
        + issuanceDate
        +
        '}';
  }
}
