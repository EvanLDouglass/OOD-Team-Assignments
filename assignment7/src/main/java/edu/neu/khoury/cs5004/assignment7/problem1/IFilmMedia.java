package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;

/**
 * Describes the general behavior of some film media such as a movie or TV series. It is assumed the
 * film media is a finished work with a title, year of release, director(s) and actor(s), which
 * cannot change. {@code IFilmMedia} does allow for a mutable "alias" filed in which users can set
 * their own alias, or nickname, for the media.
 *
 * @author evandouglass
 */
public interface IFilmMedia {

  /**
   * Returns an alias that has been assigned to this media.
   *
   * @return the alias assigned to this media
   */
  String getAlias();

  /**
   * Assigns a new alias for this media.
   *
   * @param alias the new alias for this media
   */
  void setAlias(String alias) throws NullObjectException;

  /**
   * Returns the title of this media.
   *
   * @return the title of this media
   */
  String getTitle();

  /**
   * Returns the year in which this media was released.
   *
   * @return the year of release, as a four digit integer
   */
  Integer getYearOfRelease();

  /**
   * Returns a list of the directors who worked on this media, as {@code Name} objects.
   *
   * @return a list of directors who worked on this media
   */
  List<Name> getDirectors();

  /**
   * Returns a list of the main actors who starred in this media, as {@code Name} objects.
   *
   * @return a list of the main actors who starred in this media
   */
  List<Name> getMainActors();
}
