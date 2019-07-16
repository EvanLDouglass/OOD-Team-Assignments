package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.List;
import java.util.Objects;

public class VehicleInsuranceInfo {
  private Name officialOwner;
  private List<Name> peopleCoverd;
  private Date expirationDate;

  public VehicleInsuranceInfo(Name officialOwner,
      List<Name> peopleCoverd, Date expirationDate) {
    this.officialOwner = officialOwner;
    this.peopleCoverd = peopleCoverd;
    this.expirationDate = expirationDate;
  }

  public Name getOfficialOwner() {
    return officialOwner;
  }

  public List<Name> getPeopleCoverd() {
    return peopleCoverd;
  }

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
    return Objects.equals(officialOwner, that.officialOwner) &&
        Objects.equals(peopleCoverd, that.peopleCoverd) &&
        Objects.equals(expirationDate, that.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(officialOwner, peopleCoverd, expirationDate);
  }
}
