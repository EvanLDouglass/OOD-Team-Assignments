package edu.neu.khoury.cs5004.assignment7.problem1;

import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.AliasAlreadyExistsException;
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.AliasNotFoundException;
import java.util.List;

/**
 * Describes the functionality of a media library of movies and tv series.
 *
 * @author evandouglass
 */
public interface IFilmMediaLibrary {

  /**
   * Adds an {@code IFilmMedia} object to the the media library.
   *
   * @param media the media to add, either a Movie or TVShow
   * @throws AliasAlreadyExistsException if the alias given to the media is already used in this
   *     library
   */
  void add(IFilmMedia media) throws AliasAlreadyExistsException;

  /**
   * Determines if this library contains media with the given unique alias.
   *
   * @param alias the alias to search for
   * @return true if the library contains the media, else false
   */
  Boolean contains(String alias);

  /**
   * Streams an {@code IFilmMedia} object. At this time, {@code streamMedia} only increments the
   * recorded number of times that something was streamed.
   *
   * @param alias the alias for a movie or tv show to stream
   * @throws AliasNotFoundException if the given alias is not attached to any media in the library
   */
  void streamMedia(String alias) throws AliasNotFoundException;

  /**
   * Returns the most streamed {@code IFilmMedia} object in this media library.
   *
   * @return the most streamed movie or tv show in this media library
   */
  IFilmMedia getMostStreamed();

  /**
   * Returns the number of times some media with the given alias has been streamed.
   *
   * @param alias the alias of the media to check
   * @return the number of time the media has been streamed
   * @throws AliasNotFoundException if the given alias is not attached to any media in the library
   */
  Integer getTimesStreamed(String alias) throws AliasNotFoundException;

  /**
   * Given a director's name, returns a list of the {@code IFilmMedia} objects that were directed by
   * that director.
   *
   * @param directorName the Name of a director to search for
   * @return a list of the movies and tv shows that were directed by the given director
   */
  List<IFilmMedia> getMediaFromDirector(Name directorName);
}
