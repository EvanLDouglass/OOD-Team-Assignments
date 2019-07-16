package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;

public class TVSeries extends AbstractFilmMedia {

  /**
   * Main constructor for a {@code TVSeries}.
   *
   * @param alias an alias/nickname for the TVSeries
   * @param title the TVSeries's title
   * @param yearOfRelease the TVSeries's year of release
   * @param directors a list of the directors who worked on the TVSeries
   * @param mainActors a list of main actors who worked on the TVSeries
   * @throws NullObjectException if any of the parameters are null
   */
  public TVSeries(String alias, String title, Integer yearOfRelease,
      List<Name> directors,
      List<Name> mainActors) throws NullObjectException {
    super(alias, title, yearOfRelease, directors, mainActors);
  }

  /* Methods */

  @Override
  public String toString() {
    return "TVSeries{" + super.toString() + "}";
  }
}
