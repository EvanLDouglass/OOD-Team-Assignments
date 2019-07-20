package edu.neu.khoury.cs5004.assignment7.problem1;

<<<<<<< HEAD
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.AliasAlreadyExistsException;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import edu.neu.khoury.cs5004.assignment7.problem1.Exceptions.AliasAlreadyExistsException;
=======

>>>>>>> Too many changes
=======
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.AliasNotFoundException;
>>>>>>> Add tests for media library and refactor
import java.util.ArrayList;
>>>>>>> Update everything! Due to implementing MediaLibrary
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Implementation of the {@code IFilmMediaLibrary} interface.
 *
 * Note: Currently only supports creation of an empty media library, cannot import items.
 *
 * @author evandouglass
 */
public abstract class AbstractFilmMediaLibrary implements IFilmMediaLibrary {

  // Ideally, the information stored in these fields should be kept in a database. These fields
  // basically store data that would be returned by individual queries.
  //
  // While I tried to split this information into other classes, it became either far too convoluted
  // or redundant and unnecessary.
  //
  // Finally, I have opted to use space over time. Space is cheap these days, but consumers won't
  // tolerate long load times.
  private Map<String, IFilmMedia> aliasToMedia;
  private Map<Name, Set<IFilmMedia>> dirNameToMediaSet;
  private IFilmMedia mostStreamed;

  /**
   * Empty constructor for an {@code AbstractFilmMediaLibrary}.
   */
  public AbstractFilmMediaLibrary() {
    this.aliasToMedia = new HashMap<>();
    this.dirNameToMediaSet = new HashMap<>();
  }

  /* Methods */

  @Override
  public void add(IFilmMedia media) throws AliasAlreadyExistsException {
    // Again, ideally these methods should be updates to a database. As the specs are now, individual
    // methods must be added for each type of data.
    addToMediaSearch(media);
    addToDirectorSearch(media);
  }

  /**
   * Adds the given media to a map that allows searching media by an alias.
   *
   * @param media the media to add
   * @throws AliasAlreadyExistsException if the media's alias is already used in the map. Client
   *   programs will be creating the media objects, so will need to check if their alias causes
   *   an exception.
   */
  private void addToMediaSearch(IFilmMedia media) throws AliasAlreadyExistsException {
    if (aliasToMedia.containsKey(media.getAlias())) {
      throw new AliasAlreadyExistsException();
    }
    String alias = media.getAlias();
    aliasToMedia.put(alias, media);
  }

  /**
   * Adds the given media's directors to the possible search results for director-to-media. Or, if
   * the directors are in the results already, adds the media to their set of movies.
   *
   * @param media the media to add
   */
  private void addToDirectorSearch(IFilmMedia media) {
    List<Name> dirNames = media.getDirectors();
    for (Name name : dirNames) {
      if (dirNameToMediaSet.containsKey(name)) {
        // Add this media to each Director in the library
        dirNameToMediaSet.get(name).add(media);
      } else {
        // Make new set and add this media
        Set<IFilmMedia> set = new TreeSet<>();  // keeps media sorted newest to oldest
        set.add(media);
        dirNameToMediaSet.put(name, set);
      }
    }
  }

  @Override
  public Boolean contains(String alias) {
    return aliasToMedia.containsKey(alias);
  }

  @Override
  public List<IFilmMedia> getMediaFromDirector(Name directorName) {
    Set<IFilmMedia> mediaSet = dirNameToMediaSet.get(directorName);
    return new ArrayList<>(mediaSet);  // returned sorted due to the tree set
  }

  @Override
  public void streamMedia(String alias) throws AliasNotFoundException {
    IFilmMedia media = aliasToMedia.get(alias);
    if (media == null) {
      throw new AliasNotFoundException();
    }
    media.incrementTimesStreamed();
    if (mostStreamed == null || media.getTimesStreamed() > mostStreamed.getTimesStreamed()) {
      mostStreamed = media;
    }
  }

  @Override
  public IFilmMedia getMostStreamed() {
    return mostStreamed;
  }

  @Override
  public Integer getTimesStreamed(String alias) throws AliasNotFoundException {
    IFilmMedia media = aliasToMedia.get(alias);
    if (media == null) {
      // Same expected behavior of a hash map
      throw new AliasNotFoundException();
    }
    return media.getTimesStreamed();
  }
}
