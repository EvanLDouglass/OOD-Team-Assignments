package edu.neu.khoury.cs5004.assignment7.problem2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Date {
  private LocalDate localDate;

  public Date(int day, int month, int year) {
    this.localDate = LocalDate.of(year, month, day);
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public int getMonthDuration() {
    Integer duration = (int) ChronoUnit.MONTHS.between(this.getLocalDate(), LocalDate.now());
    return duration;
  }

  public int getYearDuration() {
    Integer duration = (int) ChronoUnit.YEARS.between(this.getLocalDate(), LocalDate.now());
    return duration;
  }

  public int getDayDuration() {
    Integer duration = (int) ChronoUnit.DAYS.between(this.getLocalDate(), LocalDate.now());
    return duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Date date = (Date) o;
    return Objects.equals(localDate, date.localDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(localDate);
  }

  @Override
  public String toString() {
    return "Date{" +
        "localDate=" + localDate +
        '}';
  }
}


