package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import edu.neu.khoury.cs5004.assignment7.problem1.Exceptions.EmptyNameException;
import edu.neu.khoury.cs5004.assignment7.problem1.Exceptions.NullObjectException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class AbstractFilmProfessionalTest {

  private ConcreteFilmProfessional prof;

  @Before
  public void setUp() throws Exception {
    prof = new ConcreteFilmProfessional(new Name("Works", "In", "Film"));
  }

  @Test
  public void addAndGetMedia() throws NullObjectException, EmptyNameException {
    // Make professionals lists
    List<Name> actList = new ArrayList<>();
    List<Name> dirList = new ArrayList<>();

    // Make film media
    IFilmMedia media1990 = new Movie("movie", "Movie Title", 1990, dirList, actList);
    IFilmMedia media1995 = new Movie("movie", "Movie Title", 1995, dirList, actList);
    IFilmMedia media2000 = new Movie("movie", "Movie Title", 2000, dirList, actList);
    IFilmMedia media2005 = new Movie("movie", "Movie Title", 2005, dirList, actList);

    prof.addMedia(media1995);
    prof.addMedia(media1990);
    prof.addMedia(media2005);
    prof.addMedia(media2000);

    List<IFilmMedia> mediaList = prof.getMedia();
    assertEquals(media2005, mediaList.get(0));
    assertEquals(media2000, mediaList.get(1));
    assertEquals(media1995, mediaList.get(2));
    assertEquals(media1990, mediaList.get(3));
  }

  @Test
  public void getName() {
    assertEquals("Works In Film", prof.getName().toString());
  }

  @Test
  public void equals1() throws NullObjectException, EmptyNameException {
    assertEquals(prof, prof);
    ConcreteFilmProfessional prof1 = new ConcreteFilmProfessional(new Name("Works", "In", "Film"));
    assertEquals(prof1, prof);

    // Make a media object
    List<Name> actList = new ArrayList<>();
    List<Name> dirList = new ArrayList<>();
    IFilmMedia movie = new Movie("movie", "Movie Title", 1990, dirList, actList);

    // add to both
    prof1.addMedia(movie);
    prof.addMedia(movie);
    assertEquals(prof1, prof);
  }

  @Test
  public void notEqualsBasic() throws NullObjectException, EmptyNameException {
    assertNotEquals(null, prof);
    assertNotEquals("prof", prof);

    ConcreteFilmProfessional prof1 = new ConcreteFilmProfessional(new Name("Works", "In", "Film"));
    // Make a media object
    List<Name> actList = new ArrayList<>();
    List<Name> dirList = new ArrayList<>();
    IFilmMedia movie = new Movie("movie", "Movie Title", 1990, dirList, actList);
    // add to prof1
    prof1.addMedia(movie);
    assertNotEquals(prof1, prof);

    prof1 = new ConcreteFilmProfessional(new Name("Not", "The", "Same"));
    assertNotEquals(prof1, prof);
  }

  @Test
  public void hashCodeEquals() throws NullObjectException, EmptyNameException {
    assertEquals(prof.hashCode(), prof.hashCode());
    ConcreteFilmProfessional prof1 = new ConcreteFilmProfessional(new Name("Works", "In", "Film"));
    assertEquals(prof1.hashCode(), prof.hashCode());

    // Make a media object
    List<Name> actList = new ArrayList<>();
    List<Name> dirList = new ArrayList<>();
    IFilmMedia movie = new Movie("movie", "Movie Title", 1990, dirList, actList);

    // add to both
    prof1.addMedia(movie);
    prof.addMedia(movie);
    assertEquals(prof1.hashCode(), prof.hashCode());
  }

  @Test
  public void hashCodeNotEquals() throws NullObjectException, EmptyNameException {
    ConcreteFilmProfessional prof1 = new ConcreteFilmProfessional(new Name("Works", "In", "Film"));
    // Make a media object
    List<Name> actList = new ArrayList<>();
    List<Name> dirList = new ArrayList<>();
    IFilmMedia movie = new Movie("movie", "Movie Title", 1990, dirList, actList);
    // add to prof1
    prof1.addMedia(movie);
    assertNotEquals(prof1.hashCode(), prof.hashCode());

    prof1 = new ConcreteFilmProfessional(new Name("Not", "The", "Same"));
    assertNotEquals(prof1.hashCode(), prof.hashCode());
  }

  @Test
  public void toStringMain() throws NullObjectException, EmptyNameException {
    List<Name> actList = new ArrayList<>();
    List<Name> dirList = new ArrayList<>();

    // Make film media
    IFilmMedia movie1 = new Movie("movie1", "Movie Title", 1990, dirList, actList);
    IFilmMedia tv1 = new TVSeries("tv1", "Series Title", 1995, dirList, actList);
    IFilmMedia movie2 = new Movie("movie2", "Movie Title 2", 2000, dirList, actList);
    IFilmMedia tv2 = new Movie("tv2", "Series Title, Season 2", 2005, dirList, actList);

    prof.addMedia(movie1);
    prof.addMedia(movie2);
    prof.addMedia(tv1);
    prof.addMedia(tv2);

    String expected = "Works In Film, media:['Series Title, Season 2', 'Movie Title 2', 'Series Title', 'Movie Title']";
    assertEquals(expected, prof.toString());
  }

  @Test
  public void toStringEmptyList() {
    String expected = "Works In Film, media:[]";
    assertEquals(expected, prof.toString());
  }

  /* Helper Class */
  private class ConcreteFilmProfessional extends AbstractFilmProfessional {

    public ConcreteFilmProfessional(Name name) {
      super(name);
    }
  }
}