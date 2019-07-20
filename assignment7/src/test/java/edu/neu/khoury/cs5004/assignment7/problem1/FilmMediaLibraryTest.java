package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.AliasAlreadyExistsException;
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.AliasNotFoundException;
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.EmptyNameException;
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.NullObjectException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FilmMediaLibraryTest {

  private FilmMediaLibrary lib;
  private Movie movie1;
  private TvSeries series1;
  private Movie movie2;
  private TvSeries series2;

  @Before
  public void setUp() throws Exception {
    List<Name> actList = new ArrayList<>();
    actList.add(new Name("Act", "Number", "1"));
    actList.add(new Name("Actor", "Num", "2"));
    List<Name> dirList = new ArrayList<>();
    dirList.add(new Name("Evan", "Douglass"));
    List<Name> dirList2 = new ArrayList<>();
    dirList2.add(new Name("George", "Lucas"));
    dirList2.add(new Name("Evan", "Douglass"));

    movie1 = new Movie("movie1", "Movie Title", 1990, dirList, actList);
    series1 = new TvSeries("series1", "Series Title", 1995, dirList, actList);
    movie2 = new Movie("movie2", "Another Movie Title", 2000, dirList, actList);
    series2 = new TvSeries("series2", "Another Series Title", 2005, dirList2, actList);

    lib = new FilmMediaLibrary();
  }

  @Test
  public void addAndContains() throws AliasAlreadyExistsException {
    lib.add(movie1);
    lib.add(movie2);
    lib.add(series1);
    lib.add(series2);
    assertTrue(lib.contains("movie1"));
    assertTrue(lib.contains("series1"));
    assertTrue(lib.contains("movie2"));
    assertTrue(lib.contains("series2"));
  }

  @Test(expected = AliasAlreadyExistsException.class)
  public void addSameAlias() throws AliasAlreadyExistsException {
    lib.add(movie1);
    lib.add(movie1);
  }

  @Test
  public void getMediaFromDirector_MultipleMedia()
      throws AliasAlreadyExistsException, NullObjectException, EmptyNameException {
    List<IFilmMedia> expected = new ArrayList<>(4);
    expected.add(series2);
    expected.add(movie2);
    expected.add(series1);
    expected.add(movie1);

    // Set up library
    lib.add(movie1);
    lib.add(movie2);
    lib.add(series1);
    lib.add(series2);
    List<IFilmMedia> actual = lib.getMediaFromDirector(new Name("Evan", "Douglass"));

    assertEquals(expected, actual);
  }

  @Test
  public void getMediaFromDirector_SingleMedia()
      throws AliasAlreadyExistsException, NullObjectException, EmptyNameException {
    List<IFilmMedia> expected = new ArrayList<>(1);
    expected.add(series2);

    // Set up library
    lib.add(movie1);
    lib.add(movie2);
    lib.add(series1);
    lib.add(series2);

    List<IFilmMedia> actual = lib.getMediaFromDirector(new Name("George", "Lucas"));
    assertEquals(expected, actual);
  }

  @Test
  public void streamMediaAndGetTimesStreamed()
      throws AliasAlreadyExistsException, AliasNotFoundException {
    // Set up library
    lib.add(movie1);
    lib.add(movie2);
    lib.add(series1);
    lib.add(series2);

    lib.streamMedia("movie1");
    lib.streamMedia("movie1");
    lib.streamMedia("movie1");
    lib.streamMedia("movie1");
    lib.streamMedia("series2");
    lib.streamMedia("series2");
    lib.streamMedia("movie2");

    assertEquals(4, (int) lib.getTimesStreamed("movie1"));
    assertEquals(2, (int) lib.getTimesStreamed("series2"));
    assertEquals(1, (int) lib.getTimesStreamed("movie2"));
    assertEquals(0, (int) lib.getTimesStreamed("series1"));
  }

  @Test(expected = AliasNotFoundException.class)
  public void streamMediaNotInLibrary() throws AliasNotFoundException {
    lib.streamMedia("movie1");
  }

  @Test(expected = AliasNotFoundException.class)
  public void getTimesStreamedOfMediaNotInLibrary() throws AliasNotFoundException {
    lib.getTimesStreamed("movie1");
  }

  @Test
  public void getMostStreamed() throws AliasAlreadyExistsException, AliasNotFoundException {
    lib.add(movie1);
    lib.add(movie2);
    lib.add(series1);
    lib.add(series2);

    lib.streamMedia("movie1");
    lib.streamMedia("movie1");
    lib.streamMedia("movie1");
    lib.streamMedia("movie1");
    lib.streamMedia("series2");
    lib.streamMedia("series2");
    lib.streamMedia("movie2");

    assertEquals(movie1, lib.getMostStreamed());
  }
}