package edu.neu.khoury.cs5004.assignment7.problem1;

/**
 * Describes the functionality of a media library of movies and tv series.
 *
 * @author evandouglass
 */
public interface IMediaLibrary {

  void add(IFilmMedia media) throws AliasAlreadyExistsException;

  IFilmMedia getMediaFrom(Name directorName);

  IFilmMedia getMostStreamed();

  Integer getTimesStreamed(String alias);
}
