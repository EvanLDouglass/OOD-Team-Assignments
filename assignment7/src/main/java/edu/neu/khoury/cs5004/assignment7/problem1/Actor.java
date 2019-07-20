package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;

/**
 * Represents a film actor.
 *
 * @author evandouglass
 */
public class Actor extends AbstractFilmProfessional {

  /**
   * Constructor for an {@code Actor}.
   *
   * @param name the name of this actor
   */
  public Actor(Name name, List<IFilmMedia> media) {
    super(name);
  }

  /**
   * Basic constructor for {@code Actor} with only a name parameter. Initializes the movies and tv
   * series as empty {@code ArrayList}s.
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
