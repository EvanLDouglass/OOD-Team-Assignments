package edu.neu.khoury.cs5004.assignment7.problem1;

import com.sun.javaws.exceptions.InvalidArgumentException;
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.NullObjectException;
import java.util.List;

/**
 * Represents a series, with fields for an alias, title, year of release, a list of directors, and a
 * list of main actors.
 *
 * @author evandouglass
 */
public class TvSeries extends AbstractFilmMedia {

  /**
   * Main constructor for a {@code TvSeries}.
   *
   * @param alias an alias/nickname for the TvSeries
   * @param title the TvSeries's title
   * @param yearOfRelease the TvSeries's year of release
   * @param directors a list of the directors who worked on the TvSeries
   * @param mainActors a list of main actors who worked on the TvSeries
   * @throws NullObjectException if any of the parameters are null
   */
  public TvSeries(String alias, String title, Integer yearOfRelease,
      List<Name> directors,
      List<Name> mainActors) throws NullObjectException, InvalidArgumentException {
    super(alias, title, yearOfRelease, directors, mainActors);
  }

  /* Methods */

  @Override
  public String toString() {
    return "TvSeries{" + super.toString() + "}";
  }
}
