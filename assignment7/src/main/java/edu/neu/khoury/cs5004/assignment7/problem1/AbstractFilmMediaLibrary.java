package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the {@code IFilmMediaLibrary} interface.
 *
 * Note: Currently only supports creation of an empty media library, cannot import items.
 *
 * @author evandouglass
 */
public abstract class AbstractFilmMediaLibrary implements IFilmMediaLibrary {

  // Ideally, the information stored in these fields should be kept in a database
  private Map<String, IFilmMedia> aliasToMedia;
  private Map<Name, Director> nameToDirector;
  private Map<String, Integer> timesStreamed;

  /**
   * Empty constructor for an {@code AbstractFilmMediaLibrary}. Initializes fields to be non-null.
   */
  public AbstractFilmMediaLibrary() {
    this.aliasToMedia = new HashMap<>();
    this.nameToDirector = new HashMap<>();
    this.timesStreamed = new HashMap<>();
  }

  /* Methods */

  @Override
  public void add(IFilmMedia media) throws AliasAlreadyExistsException {

  }

  @Override
  public List<IFilmMedia> getMediaFrom(Name directorName) {
    return null;
  }

  @Override
  public IFilmMedia getMostStreamed() {
    return null;
  }

  @Override
  public Integer getTimesStreamed(String alias) {
    return null;
  }

  @Override
  public void streamMedia(String alias) {

  }
}
