package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;
import java.util.Objects;

/**
 * Provides an implementation of the {@code IFilmMedia} interface.
 *
 * @author evandouglass
 */
public abstract class AbstractFilmMedia implements IFilmMedia {

  private String alias;
  private String title;
  // TODO: validate year is four digits
  private Integer yearOfRelease;
  private List<Name> directors;
  private List<Name> mainActors;

  /**
   * Main constructor for {@code AbstractFilmMedia}.
   *
   * @param alias an alias/nickname for the media
   * @param title the media's title
   * @param yearOfRelease the media's year of release
   * @param directors a list of the directors who worked on the media
   * @param mainActors a list of main actors who worked on the media
   * @throws NullObjectException if any of the parameters are null
   */
  public AbstractFilmMedia(String alias, String title, Integer yearOfRelease,
      List<Name> directors, List<Name> mainActors) throws NullObjectException {
    validateConstructor(alias, title, yearOfRelease, directors, mainActors);
    this.alias = alias;
    this.title = title;
    this.yearOfRelease = yearOfRelease;
    this.directors = directors;
    this.mainActors = mainActors;
  }

  /* Validators */

  /**
   * Ensures no fields are null.
   *
   * @param alias an alias/nickname for the media
   * @param title the media's title
   * @param yearOfRelease the media's year of release
   * @param directors a list of the directors who worked on the media
   * @param mainActors a list of main actors who worked on the media
   * @throws NullObjectException if any of the parameters are null
   */
  private void validateConstructor(String alias, String title, Integer yearOfRelease,
      List<Name> directors, List<Name> mainActors) throws NullObjectException {
    String notNull = "cannot be null";
    validateNotNull(alias, "alias " + notNull);
    validateNotNull(title, "title " + notNull);
    validateNotNull(yearOfRelease, "year of release " + notNull);
    validateNotNull(directors, "directors list " + notNull);
    validateNotNull(mainActors, "actors list " + notNull);
  }

  /**
   * Ensures that a given object is not null.
   *
   * @param obj an object to test
   * @param message a message to include in the exception if thrown
   * @throws NullObjectException if the given object is null
   */
  private void validateNotNull(Object obj, String message) throws NullObjectException {
    if (obj == null) {
      throw new NullObjectException(message);
    }
  }

  /**
   * Ensures that the given year is four digits.
   *
   * @param year a year to test
   * @throws InvalidYearException if the given year is not four digits
   */
  private void validateYearFourDigits(Integer year) throws InvalidYearException {
    // TODO: Implement this
  }

  /**
   * Counts the number of digits in a given number. Ignores the sign of the given integer.
   *
   * @param num an integer
   * @return the number of digits in the integer
   */
  private Integer countNumDigits(Integer num) {
    // TODO: Implement this
    return null;
  }

  // TODO: ensure year is in a reasonable range (i.e. from first film to current year)

  /* Methods */

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractFilmMedia that = (AbstractFilmMedia) obj;
    return alias.equals(that.alias)
        && title.equals(that.title)
        && yearOfRelease.equals(that.yearOfRelease)
        && directors.equals(that.directors)
        && mainActors.equals(that.mainActors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alias, title, yearOfRelease, directors, mainActors);
  }

  @Override
  public String toString() {
    return String.format("alias:'%s', title:'%s', released:%d, directors:%s, actors:%s",
        alias, title, yearOfRelease, listToString(directors), listToString(mainActors));
  }

  /**
   * Builds a string representing the items in a list of {@code Name} objects.
   *
   * @param list the list of Names to represent as a string
   * @return a string representing the list
   */
  private String listToString(List<Name> list) {
    // Take care of empty list
    if (list.isEmpty()) {
      return "[]";
    }
    // Add first element
    StringBuilder builder = new StringBuilder();
    builder.append('[');
    builder.append(list.get(0).toString());
    // Add rest of list if it exists w/ separating commas
    for (int i = 1; i < list.size(); i++) {
      builder.append(", ");
      builder.append(list.get(i).toString());
    }
    // Add last brace
    builder.append(']');
    return builder.toString();
  }

  /* Getters and Setters */

  /**
   * Returns an alias that has been assigned to this media.
   *
   * @return the alias assigned to this media
   */
  @Override
  public String getAlias() {
    return alias;
  }

  /**
   * Assigns a new alias for this media.
   *
   * @param alias the new alias for this media
   * @throws NullObjectException if the given alias is null
   */
  @Override
  public void setAlias(String alias) throws NullObjectException {
    validateNotNull(alias, "alias cannot be null");
    this.alias = alias;
  }

  /**
   * Returns the title of this media.
   *
   * @return the title of this media
   */
  @Override
  public String getTitle() {
    return title;
  }

  /**
   * Returns the year in which this media was released.
   *
   * @return the year of release, as a four digit integer
   */
  @Override
  public Integer getYearOfRelease() {
    return yearOfRelease;
  }

  /**
   * Returns a list of the directors who worked on this media.
   *
   * @return a list of directors who worked on this media
   */
  @Override
  public List<Name> getDirectors() {
    return directors;
  }

  /**
   * Returns a list of the main actors who starred in this media.
   *
   * @return a list of the main actors who starred in this media
   */
  @Override
  public List<Name> getMainActors() {
    return mainActors;
  }
}
