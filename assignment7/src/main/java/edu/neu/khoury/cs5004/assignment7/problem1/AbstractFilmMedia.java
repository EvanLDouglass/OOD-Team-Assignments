package edu.neu.khoury.cs5004.assignment7.problem1;

import static edu.neu.khoury.cs5004.assignment7.problem1.Validator.validateIntegerLength;
import static edu.neu.khoury.cs5004.assignment7.problem1.Validator.validateNotNull;

import com.sun.javaws.exceptions.InvalidArgumentException;
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.NullObjectException;
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
  private Integer yearOfRelease;
  private Integer timesStreamed;
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
      List<Name> directors, List<Name> mainActors)
      throws NullObjectException, InvalidArgumentException {
    validateConstructor(alias, title, yearOfRelease, directors, mainActors);
    this.alias = alias;
    this.title = title;
    this.yearOfRelease = yearOfRelease;
    this.directors = directors;
    this.mainActors = mainActors;
    this.timesStreamed = 0;  // can't have been streamed before creation
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
      List<Name> directors, List<Name> mainActors)
      throws NullObjectException, InvalidArgumentException {
    String notNull = "cannot be null";
    validateNotNull(alias, "alias " + notNull);
    validateNotNull(title, "title " + notNull);
    validateNotNull(yearOfRelease, "year of release " + notNull);
    validateYearFourDigits(yearOfRelease);
    validateNotNull(directors, "directors list " + notNull);
    validateNotNull(mainActors, "actors list " + notNull);
  }

  /**
   * Ensures that the given year is four digits.
   *
   * @param year a year to test
   * @throws InvalidArgumentException if the given year is not four digits
   */
  private void validateYearFourDigits(Integer year) throws InvalidArgumentException {
    validateIntegerLength(year, 4);
  }

  /* Methods */

  /**
   * Compares this object with the specified object for order.  Returns a negative integer, zero, or
   * a positive integer as this object is less than, equal to, or greater than the specified object.
   * Note: this class has a natural ordering that is inconsistent with equals. It is based on the
   * release date of the movie, with more recent release dates classified as less than others.
   *
   * @param other the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
   *     or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException if the specified object's type prevents it from being compared to
   *     this object.
   */
  @Override
  public int compareTo(IFilmMedia other) {
    Integer thisReleaseYear = yearOfRelease;
    Integer otherReleaseYear = other.getYearOfRelease();
    return otherReleaseYear - thisReleaseYear;  // if other is older, this classified as lesser
  }

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

  @Override
  public Integer getTimesStreamed() {
    return timesStreamed;
  }

  @Override
  public void incrementTimesStreamed() {
    this.timesStreamed++;
  }
}
