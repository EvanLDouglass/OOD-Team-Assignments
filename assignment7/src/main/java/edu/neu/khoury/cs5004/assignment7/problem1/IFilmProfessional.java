package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;

/**
 * Describes the basic expected functionality of someone that works on film projects (i.e. movies,
 * tv series) for a living.
 *
 * @author evandouglass
 */
public interface IFilmProfessional {

  /**
   * Adds a {@code IFilmMedia} object to this professional's resume.
   *
   * @param media the media that this professional worked on
   */
  void addMedia(IFilmMedia media);

  /**
   * Returns the name of this film professional.
   *
   * @return the name of this film professional
   */
  Name getName();

  /**
   * Returns a list of the {@code Movie}s and {@code TVSeries} that this professional worked on,
   * ordered by most recent to oldest.
   *
   * @return an ordered list of movies and series, by year of release
   */
  List<IFilmMedia> getMedia();
}
