package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implements the {@code IFilmProfessional} interface. This class is optimized for returning a
 * sorted list of media they have worked on (insertion sort applied when media is added).
 *
 * @author evandouglass
 */
public abstract class AbstractFilmProfessional implements IFilmProfessional {

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
   * Basic constructor for {@code AbstractFilmProfessional} with only a name parameter.
   *
   * @param name the name of this professional
   */
  public AbstractFilmProfessional(Name name) {
    this(name, new ArrayList<>());
  }

  /* Methods */

  @Override
  public void addMedia(IFilmMedia media) {
    Integer index = findInsertionIndex(media);
    if (index == this.media.size()) {
      // Add to end if this had the earliest year
      this.media.add(media);
      return;
    }
    this.media.add(index, media);
  }

  /**
   * Determines the index at which the given {@code IFilmMedia} object should be inserted into the
   * media list in order to maintain a descending order of release year.
   *
   * @param media the media to add
   * @return the index at which to insert the given media
   */
  private Integer findInsertionIndex(IFilmMedia media) {
    Integer len = this.media.size();
    // For empty lists
    if (len == 0) {
      return 0;
    }
    // For non-empty lists
    Integer yearNew = media.getYearOfRelease();
    for (int i = 0; i < len; i++) {
      Integer yearOld = this.media.get(i).getYearOfRelease();
      if (yearNew > yearOld) {
        return i;
      }
    }
    return len;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractFilmProfessional that = (AbstractFilmProfessional) obj;
    return name.equals(that.name)
        && media.equals(that.media);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, media);
  }

  @Override
  public String toString() {
    return name.toString() + ", media:" + mediaListToString();
  }

  /**
   * Creates a string to represent a list of film. Media are represented based on their titles.
   * At this time, there is no distinction between sub-classes of {@code IFilmMedia}.
   *
   * @return a string representing a list of film media
   */
  private String mediaListToString() {
    // For empty
    if (media.isEmpty()) {
      return "[]";
    }
    // For non-empty
    StringBuilder builder = new StringBuilder();
    builder.append('[');
    // first
    builder.append("'");
    builder.append(media.get(0).getTitle());
    builder.append("'");
    // rest
    for (int i = 1; i < media.size(); i++) {
      builder.append(", '");
      builder.append(media.get(i).getTitle());
      builder.append("'");
    }
    // closing brace
    builder.append(']');
    return builder.toString();
  }

  /* Getters */

  @Override
  public List<IFilmMedia> getMedia() {
    return media;
  }

  @Override
  public Name getName() {
    return name;
  }
}
