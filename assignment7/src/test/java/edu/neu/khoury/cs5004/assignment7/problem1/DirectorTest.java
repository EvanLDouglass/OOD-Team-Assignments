package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class DirectorTest {

  private Director director;

  @Before
  public void setUp() throws Exception {
    director = new Director(new Name("Director", "Person"));

    List<Name> actList = new ArrayList<>();
    List<Name> dirList = new ArrayList<>();
    dirList.add(director.getName());

    // Make film media
    IFilmMedia movie1 = new Movie("movie1", "Movie Title", 1990, dirList, actList);
    IFilmMedia tv1 = new TVSeries("tv1", "Series Title", 1995, dirList, actList);
    IFilmMedia movie2 = new Movie("movie2", "Movie Title 2", 2000, dirList, actList);
    IFilmMedia tv2 = new Movie("tv2", "Series Title, Season 2", 2005, dirList, actList);

    // Add media to director
    director.addMedia(movie1);
    director.addMedia(movie2);
    director.addMedia(tv1);
    director.addMedia(tv2);
  }

  @Test
  public void toString1() {
  }
}