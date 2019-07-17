package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.List;
import java.util.Objects;

/**
 * The type Vehicle insurance info.
 */
public class VehicleInsuranceInfo {
  private Name officialOwner;
  private List<Name> peopleCoverd;
  private Date expirationDate;

  /**
   * Instantiates a new Vehicle insurance info.
   *
   * @param officialOwner the official owner
   * @param peopleCoverd the people coverd
   * @param expirationDate the expiration date
   */
  public VehicleInsuranceInfo(Name officialOwner,
      List<Name> peopleCoverd, Date expirationDate) {
    this.officialOwner = officialOwner;
    this.peopleCoverd = peopleCoverd;
    this.expirationDate = expirationDate;
  }

  /**
   * Gets official owner.
   *
   * @return the official owner
   */
  public Name getOfficialOwner() {
    return officialOwner;
  }

  /**
   * Gets people coverd.
   *
   * @return the people coverd
   */
  public List<Name> getPeopleCoverd() {
    return peopleCoverd;
  }

  /**
   * Gets expiration date.
   *
   * @return the expiration date
   */
  public Date getExpirationDate() {
    return expirationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleInsuranceInfo that = (VehicleInsuranceInfo) o;
    return Objects.equals(officialOwner, that.officialOwner)
        &&
        Objects.equals(peopleCoverd, that.peopleCoverd)
        &&
        Objects.equals(expirationDate, that.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(officialOwner, peopleCoverd, expirationDate);
  }

  @Override
  public String toString() {
    return "VehicleInsuranceInfo{" +
        "officialOwner=" + officialOwner +
        ", peopleCoverd=" + peopleCoverd +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
