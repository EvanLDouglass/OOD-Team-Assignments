package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

public class VehicleInfo {
  private String make;
  private String model;
  private Date year;
  private Name officialOwner;

  public VehicleInfo(String make, String model, Date year,
      Name officialOwner) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.officialOwner = officialOwner;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public Date getYear() {
    return year;
  }

  public Name getOfficialOwner() {
    return officialOwner;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleInfo that = (VehicleInfo) o;
    return Objects.equals(make, that.make) &&
        Objects.equals(model, that.model) &&
        Objects.equals(year, that.year) &&
        Objects.equals(officialOwner, that.officialOwner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(make, model, year, officialOwner);
  }

  @Override
  public String toString() {
    return "VehicleInfo{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        ", officialOwner=" + officialOwner +
        '}';
  }
}
