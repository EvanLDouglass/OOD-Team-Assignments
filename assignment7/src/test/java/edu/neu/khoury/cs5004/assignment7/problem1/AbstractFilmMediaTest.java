package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractFilmMediaTest {

  private ConcreteFilmMedia media;
  private List<Name> actList;
  private List<Name> dirList;

  @Before
  public void setUp() throws Exception {
    // Make actors
    actList = new ArrayList<>();
    actList.add(new Name("Actor", "Number", "1"));
    actList.add(new Name("Actor", "Number", "2"));
    // Make director
    dirList = new ArrayList<>();
    dirList.add(new Name("Director"));
    // Make film media
    media = new ConcreteFilmMedia("movie", "Movie Title", 1990, dirList, actList);
  }

  @Test(expected = NullObjectException.class)
  public void nullAlias() throws NullObjectException {
    media = new ConcreteFilmMedia(null, "Title", 1990, dirList, actList);
  }

  @Test(expected = NullObjectException.class)
  public void nullTitle() throws NullObjectException {
    media = new ConcreteFilmMedia("alias", null, 1990, dirList, actList);
  }

  @Test(expected = NullObjectException.class)
  public void nullYear() throws NullObjectException {
    media = new ConcreteFilmMedia("alias", "Title", null, dirList, actList);
  }

  @Test(expected = NullObjectException.class)
  public void nullDirectors() throws NullObjectException {
    media = new ConcreteFilmMedia("alias", "Title", 1990, null, actList);
  }

  @Test(expected = NullObjectException.class)
  public void nullActors() throws NullObjectException {
    media = new ConcreteFilmMedia(null, "Title", 1990, dirList, null);
  }

  @Test
  public void toString1() {
    String expected = "alias:'movie', title:'Movie Title', released:1990, directors:[Director], "
        + "actors:[Actor Number 1, Actor Number 2]";
    assertEquals(expected, media.toString());
  }

  @Test
  public void toStringEmptyList() throws NullObjectException {
    media = new ConcreteFilmMedia("movie", "Movie Title", 1990, new ArrayList<>(), actList);
    String expected = "alias:'movie', title:'Movie Title', released:1990, directors:[], "
        + "actors:[Actor Number 1, Actor Number 2]";
    assertEquals(expected, media.toString());
  }

  @Test
  public void equalsBasic() throws NullObjectException {
    assertEquals(media, media);
    ConcreteFilmMedia media1 = new ConcreteFilmMedia("movie", "Movie Title", 1990, dirList,
        actList);
    assertEquals(media1, media);
  }

  @Test
  public void notEqualsMain() throws NullObjectException {
    ConcreteFilmMedia media1 = new ConcreteFilmMedia("M", "Movie Title", 1990, dirList, actList);
    assertNotEquals(media1, media);
    media1 = new ConcreteFilmMedia("movie", "Title", 1990, dirList, actList);
    assertNotEquals(media1, media);
    media1 = new ConcreteFilmMedia("movie", "Movie Title", 2019, dirList, actList);
    assertNotEquals(media1, media);
    media1 = new ConcreteFilmMedia("movie", "Movie Title", 1990, new ArrayList<>(), actList);
    assertNotEquals(media1, media);
    media1 = new ConcreteFilmMedia("movie", "Movie Title", 1990, dirList, new ArrayList<>());
    assertNotEquals(media1, media);
  }

  @Test
  public void notEqualsBasic() {
    assertNotEquals(null, media);
    assertNotEquals("media", media);
  }

  @Test
  public void hashCodeEquals() throws NullObjectException {
    ConcreteFilmMedia media1 = new ConcreteFilmMedia("movie", "Movie Title", 1990, dirList,
        actList);
    assertEquals(media1.hashCode(), media.hashCode());
    assertEquals(media.hashCode(), media.hashCode());
  }

  @Test
  public void hashCodeNotEquals() throws NullObjectException {
    ConcreteFilmMedia media1 = new ConcreteFilmMedia("M", "Movie Title", 1990, dirList, actList);
    assertNotEquals(media1.hashCode(), media.hashCode());
    media1 = new ConcreteFilmMedia("movie", "Title", 1990, dirList, actList);
    assertNotEquals(media1.hashCode(), media.hashCode());
    media1 = new ConcreteFilmMedia("movie", "Movie Title", 2019, dirList, actList);
    assertNotEquals(media1.hashCode(), media.hashCode());
    media1 = new ConcreteFilmMedia("movie", "Movie Title", 1990, new ArrayList<>(), actList);
    assertNotEquals(media1.hashCode(), media.hashCode());
    media1 = new ConcreteFilmMedia("movie", "Movie Title", 1990, dirList, new ArrayList<>());
    assertNotEquals(media1.hashCode(), media.hashCode());
  }

  @Test
  public void getAlias() {
    assertEquals("movie", media.getAlias());
  }

  @Test
  public void setAliasValid() throws NullObjectException {
    media.setAlias("another movie");
    assertEquals("another movie", media.getAlias());
  }

  @Test(expected = NullObjectException.class)
  public void setAliasNull() throws NullObjectException {
    media.setAlias(null);
  }

  @Test
  public void getTitle() {
    assertEquals("Movie Title", media.getTitle());
  }

  @Test
  public void getYearOfRelease() {
    assertEquals(1990, (int) media.getYearOfRelease());
  }

  @Test
  public void getDirectors() {
    assertEquals(dirList, media.getDirectors());
  }

  @Test
  public void getActors() {
    assertEquals(actList, media.getMainActors());
  }

  private class ConcreteFilmMedia extends AbstractFilmMedia {

    ConcreteFilmMedia(String alias, String title, Integer yearOfRelease,
        List<Name> directors, List<Name> mainActors) throws NullObjectException {
      super(alias, title, yearOfRelease, directors, mainActors);
    }
  }
}