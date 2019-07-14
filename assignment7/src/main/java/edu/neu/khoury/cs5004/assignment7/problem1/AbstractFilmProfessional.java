package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Implements the {@code IFilmProfessional} interface.
 *
 * @author evandouglass
 */
public abstract class AbstractFilmProfessional implements IFilmProfessional {

  private Name name;
  private List<Movie> movies;
  private List<TVSeries> series;

  /**
   * Constructor for an {@code AbstractFilmProfessional}.
   *
   * @param name the name of this professional
   * @param movies a list of movies they have worked on
   * @param series a list of tv series they have worked on
   */
  public AbstractFilmProfessional(Name name,
      List<Movie> movies, List<TVSeries> series) {
    this.name = name;
    this.movies = movies;
    this.series = series;
  }

  /**
   * Basic constructor for {@code AbstractFilmProfessional} with only a name parameter. Initializes
   * the movies and tv series as empty {@code ArrayList}s.
   *
   * @param name the name of this professional
   */
  public AbstractFilmProfessional(Name name) {
    this(name, new ArrayList<>(), new ArrayList<>());
  }

  /* Methods */

  @Override
  public void addMedia(Movie movie) {
    addMovie(movie);
  }

  @Override
  public void addMedia(TVSeries series) {
    addTVSeries(series);
  }

  /**
   * Adds a movie to the list of movies that this this person has worked on.
   *
   * @param movie the movie to add
   */
  public void addMovie(Movie movie) {
    this.movies.add(movie);
  }

  /**
   * Adds a TV series to the list of series that this person has worked on.
   *
   * @param series the TV series to add
   */
  public void addTVSeries(TVSeries series) {
    this.series.add(series);
  }

  /* Getters */

  @Override
  public List<IFilmMedia> getMedia() {
    // TODO: add together movie and tv lists, sort before return
    return null;
  }

  @Override
  public Name getName() {
    return name;
  }

  @Override
  public List<Movie> getMovies() {
    // TODO: sort by year
    return movies;
  }

  @Override
  public List<TVSeries> getTVSeries() {
    // TODO: sort by year
    return series;
  }

  /* Comparator classes */

  /**
   * A simple class used to compare two {@code IFilmMedia} objects by their year of release. Note
   * that {@code IFilmMedia} objects are not {@code Comparable}. This is because there is no clear
   * way to order these objects in a way that will be consistent with {@code equals}. It is more
   * appropriate to instead make a {@code Comparator} class in order to compare two of these objects
   * by individual fields.
   */
  private class CompareByYear implements Comparator<IFilmMedia> {

    /**
     * Compares its two arguments for order.  Returns a negative integer, zero, or a positive
     * integer as the first argument is less than, equal to, or greater than the second.<p>
     *
     * Note: this comparator imposes orderings that are inconsistent with equals. It is intended to
     * order only by the year of release of some film media.
     *
     * @param media1 the first object to be compared.
     * @param media2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than,
     * equal to, or greater than the second.
     * @throws NullPointerException if an argument is null and this comparator does not permit null
     * arguments
     * @throws ClassCastException if the arguments' types prevent them from being compared by this
     * comparator.
     */
    @Override
    public int compare(IFilmMedia media1, IFilmMedia media2) {
      Integer year1 = media1.getYearOfRelease();
      Integer year2 = media2.getYearOfRelease();
      return year1.compareTo(year2);
    }
  }
}
