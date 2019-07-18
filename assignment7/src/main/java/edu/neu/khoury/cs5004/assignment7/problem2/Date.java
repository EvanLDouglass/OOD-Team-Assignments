package edu.neu.khoury.cs5004.assignment7.problem2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * The type Date.
 */
public class Date {
  private LocalDate localDate;

  /**
   * Instantiates a new Date.
   *
   * @param day the day
   * @param month the month
   * @param year the year
   */
  public Date(int day, int month, int year) {
    this.localDate = LocalDate.of(year, month, day);
  }

  /**
   * Gets local date.
   *
   * @return the local date
   */
  public LocalDate getLocalDate() {
    return localDate;
  }

  /**
   * Gets month duration.
   *
   * @return the month duration
   */
  public int getMonthDuration() {
    Integer duration = (int) ChronoUnit.MONTHS.between(this.getLocalDate(), LocalDate.now());
    return duration;
  }

  /**
   * Gets year duration.
   *
   * @return the year duration
   */
  public int getYearDuration() {
    Integer duration = (int) ChronoUnit.YEARS.between(this.getLocalDate(), LocalDate.now());
    return duration;
  }

  /**
   * Gets day duration.
   *
   * @return the day duration
   */
  public int getDayDuration() {
    Integer duration = (int) ChronoUnit.DAYS.between(this.getLocalDate(), LocalDate.now());
    return duration;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Date date = (Date) other;
    return Objects.equals(localDate, date.localDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(localDate);
  }

  @Override
  public String toString() {
    return "Date{"
        +
        "localDate="
        + localDate
        +
        '}';
  }
}


