package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;

public class Movie extends AbstractFilmMedia {

  /**
   * Main constructor for a {@code Movie}.
   *
   * @param alias an alias/nickname for the movie
   * @param title the movie's title
   * @param yearOfRelease the movie's year of release
   * @param directors a list of the directors who worked on the movie
   * @param mainActors a list of main actors who worked on the movie
   * @throws NullObjectException if any of the parameters are null
   */
  public Movie(String alias, String title, Integer yearOfRelease,
      List<Name> directors,
      List<Name> mainActors) throws NullObjectException {
    super(alias, title, yearOfRelease, directors, mainActors);
  }
}
