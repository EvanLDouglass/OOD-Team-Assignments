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
  // TODO: Make single IFilmMedia list and then make class iterable. Use different iterators to get different types of media.
  private Name name;
  private List<IFilmMedia> media;

  /**
   * Constructor for an {@code AbstractFilmProfessional}.
   *
   * @param name the name of this professional
   * @param media a list of movies and tv series they have worked on
   */
  public AbstractFilmProfessional(Name name, List<IFilmMedia> media) {
    this.name = name;
    this.media = media;
  }

  /**
   * Basic constructor for {@code AbstractFilmProfessional} with only a name parameter. Initializes
   * the movies and tv series as empty {@code ArrayList}s.
   *
   * @param name the name of this professional
   */
  public AbstractFilmProfessional(Name name) {
    this(name, new ArrayList<>());
  }

  /* Methods */

  public void addMedia(IFilmMedia media) {

  }

  /* Getters */

  @Override
  public List<IFilmMedia> getMedia() {
    // TODO: sort before return
    return null;
  }

  @Override
  public Name getName() {
    return name;
  }

  @Override
  public List<Movie> getMovies() {
    // TODO: sort by year, filter for movies
    return null;
  }

  @Override
  public List<TVSeries> getTVSeries() {
    // TODO: sort by year, filter for TVSeries
    return null;
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
