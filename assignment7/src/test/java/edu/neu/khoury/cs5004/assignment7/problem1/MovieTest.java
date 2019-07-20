package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MovieTest {

  private Movie movie;

  @Before
  public void setUp() throws Exception {
    // Make actors
    List<Name> actList = new ArrayList<>();
    actList.add(new Name("Actor", "Number", "1"));
    actList.add(new Name("Actor", "Number", "2"));
    // Make director
    List<Name> dirList = new ArrayList<>();
    dirList.add(new Name("Director"));
    // Make film media
    movie = new Movie("movie", "Movie Title", 1990, dirList, actList);
  }

  @Test
  public void toString1() {
    String expected =
        "Movie{alias:'movie', title:'Movie Title', released:1990, directors:[Director], "
            + "actors:[Actor Number 1, Actor Number 2]}";
    assertEquals(expected, movie.toString());
  }
}