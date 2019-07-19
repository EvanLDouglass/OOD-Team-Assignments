package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * Implements the {@code IFilmProfessional} interface. This class is optimized for returning a
 * sorted list of media they have worked on (insertion sort applied when media is added).
 *
 * @author evandouglass
 */
public abstract class AbstractFilmProfessional implements IFilmProfessional {

  private Name name;

  /**
   * Constructor for an {@code AbstractFilmProfessional}.
   *
   * @param name the name of this professional
   */
  public AbstractFilmProfessional(Name name) {
    this.name = name;
  }

  /* Methods */

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractFilmProfessional that = (AbstractFilmProfessional) obj;
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name.toString();
  }

  /* Getters */

  @Override
  public Name getName() {
    return name;
  }
}
