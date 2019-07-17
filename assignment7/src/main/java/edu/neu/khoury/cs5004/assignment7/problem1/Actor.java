package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;

/**
 * Represents a film actor. Includes fields for the actor's name and lists of movies and TV series
 * in which they've acted.
 *
 * @author evandouglass
 */
public class Actor extends AbstractFilmProfessional {

  /**
   * Constructor for an {@code Actor}.
   *
   * @param name the name of this actor
   * @param media a list of movies in which they have been a main actor
   */
  public Actor(Name name, List<IFilmMedia> media) {
    super(name, media);
  }

  /**
   * Basic constructor for {@code Actor} with only a name parameter. Initializes
   * the movies and tv series as empty {@code ArrayList}s.
   *
   * @param name the name of this actor
   */
  public Actor(Name name) {
    super(name);
  }

  @Override
  public String toString() {
    return "Actor{" + super.toString() + "}";
  }
}
