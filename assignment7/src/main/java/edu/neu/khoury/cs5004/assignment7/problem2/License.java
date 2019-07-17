package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

public class License {
  private int licenseNumber;
  private Name driverName;
  private Date driverBirthdate;
  private String cuntryOrStateOfIssuance;
  private Date expirationDate;
  private Date issuanceDate;

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

  public int getLicenseNumber() {
    return licenseNumber;
  }

  public Name getDriverName() {
    return driverName;
  }

  public Date getDriverBirthdate() {
    return driverBirthdate;
  }

  public String getCuntryOrStateOfIssuance() {
    return cuntryOrStateOfIssuance;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public Date getIssuanceDate() {
    return issuanceDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    License license = (License) o;
    return licenseNumber == license.licenseNumber &&
        Objects.equals(driverName, license.driverName) &&
        Objects.equals(driverBirthdate, license.driverBirthdate) &&
        Objects.equals(cuntryOrStateOfIssuance, license.cuntryOrStateOfIssuance) &&
        Objects.equals(expirationDate, license.expirationDate) &&
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
    return "License{" +
        "licenseNumber=" + licenseNumber +
        ", driverName=" + driverName +
        ", driverBirthdate=" + driverBirthdate +
        ", cuntryOrStateOfIssuance='" + cuntryOrStateOfIssuance + '\'' +
        ", expirationDate=" + expirationDate +
        ", issuanceDate=" + issuanceDate +
        '}';
  }
}
