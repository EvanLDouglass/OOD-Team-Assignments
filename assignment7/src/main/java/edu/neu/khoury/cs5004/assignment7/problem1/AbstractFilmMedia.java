package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;

/**
 * Provides an implementation of the {@code IFilmMedia} interface.
 *
 * @author evandouglass
 */
public abstract class AbstractFilmMedia implements IFilmMedia {

  private String alias;
  private String title;
  private Integer yearOfRelease;
  private List<IDirector> directors;
  private List<IActor> mainActors;

  public AbstractFilmMedia(String alias, String title, Integer yearOfRelease,
      List<IDirector> directors,
      List<IActor> mainActors) {
    this.alias = alias;
    this.title = title;
    this.yearOfRelease = yearOfRelease;
    this.directors = directors;
    this.mainActors = mainActors;
  }

  /* Validators */
  private void validateNotNull(Object obj) throws NullObjectException {

  }
}
