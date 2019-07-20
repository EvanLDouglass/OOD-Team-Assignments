package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.EmptyNameException;
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.NullObjectException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

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
  public void nullAlias() throws NullObjectException, IllegalArgumentException {
    media = new ConcreteFilmMedia(null, "Title", 1990, dirList, actList);
  }

  @Test(expected = NullObjectException.class)
  public void nullTitle() throws NullObjectException, IllegalArgumentException {
    media = new ConcreteFilmMedia("alias", null, 1990, dirList, actList);
  }

  @Test(expected = NullObjectException.class)
  public void nullYear() throws NullObjectException, IllegalArgumentException {
    media = new ConcreteFilmMedia("alias", "Title", null, dirList, actList);
  }

  @Test(expected = IllegalArgumentException.class)
  public void yearLessThanFourDigits() throws NullObjectException, IllegalArgumentException {
    media = new ConcreteFilmMedia("alias", "Title", 13, dirList, actList);
  }

  @Test(expected = IllegalArgumentException.class)
  public void yearGreaterThanFourDigits() throws NullObjectException, IllegalArgumentException {
    media = new ConcreteFilmMedia("alias", "Title", 20000, dirList, actList);
  }

  @Test(expected = NullObjectException.class)
  public void nullDirectors() throws NullObjectException, IllegalArgumentException {
    media = new ConcreteFilmMedia("alias", "Title", 1990, null, actList);
  }

  @Test(expected = NullObjectException.class)
  public void nullActors() throws NullObjectException, IllegalArgumentException {
    media = new ConcreteFilmMedia(null, "Title", 1990, dirList, null);
  }

  @Test
  public void compareTo() throws NullObjectException, EmptyNameException, IllegalArgumentException {
    // Make actors
    actList = new ArrayList<>();
    actList.add(new Name("Actor", "Number", "1"));
    actList.add(new Name("Actor", "Number", "2"));
    // Make director
    dirList = new ArrayList<>();
    dirList.add(new Name("Director"));
    // Make film media
    ConcreteFilmMedia media1 = new ConcreteFilmMedia("movie", "Movie Title", 1980, dirList,
        actList);
    // More recent are lesser
    assertTrue(0 > media.compareTo(media1));
    // Older are larger
    assertTrue(0 < media1.compareTo(media));
  }

  @Test
  public void compareToSameYear()
      throws NullObjectException, EmptyNameException, IllegalArgumentException {
    // Shows that in this case, media object does not have to be equal, just the year
    // Make actors
    actList = new ArrayList<>();
    actList.add(new Name("Act", "Number", "1"));
    actList.add(new Name("Actor", "Num", "2"));
    // Make director
    dirList = new ArrayList<>();
    dirList.add(new Name("Director", "Person"));
    // Make film media
    ConcreteFilmMedia media1 = new ConcreteFilmMedia("movie2", "Different Movie Title", 1990,
        dirList, actList);
    assertEquals(0, media.compareTo(media1));
    assertEquals(0, media1.compareTo(media));
  }

  @Test
  public void toString1() {
    String expected = "alias:'movie', title:'Movie Title', released:1990, directors:[Director], "
        + "actors:[Actor Number 1, Actor Number 2]";
    assertEquals(expected, media.toString());
  }

  @Test
  public void toStringEmptyList() throws NullObjectException, IllegalArgumentException {
    media = new ConcreteFilmMedia("movie", "Movie Title", 1990, new ArrayList<>(), actList);
    String expected = "alias:'movie', title:'Movie Title', released:1990, directors:[], "
        + "actors:[Actor Number 1, Actor Number 2]";
    assertEquals(expected, media.toString());
  }

  @Test
  public void equalsBasic() throws NullObjectException, IllegalArgumentException {
    assertEquals(media, media);
    ConcreteFilmMedia media1 = new ConcreteFilmMedia("movie", "Movie Title", 1990, dirList,
        actList);
    assertEquals(media1, media);
  }

  @Test
  public void notEqualsMain() throws NullObjectException, IllegalArgumentException {
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
  public void notEqualsBasic() throws NullObjectException, EmptyNameException {
    assertNotEquals(null, media);
    assertNotEquals(new Name("media"), media);
  }

  @Test
  public void hashCodeEquals() throws NullObjectException, IllegalArgumentException {
    ConcreteFilmMedia media1 = new ConcreteFilmMedia("movie", "Movie Title", 1990, dirList,
        actList);
    assertEquals(media1.hashCode(), media.hashCode());
    assertEquals(media.hashCode(), media.hashCode());
  }

  @Test
  public void hashCodeNotEquals() throws NullObjectException, IllegalArgumentException {
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
  public void getTitle() {
    assertEquals("Movie Title", media.getTitle());
  }

  @Test
  public void getYearOfRelease() {
    assertEquals(1990, (int) media.getYearOfRelease());
  }

  @Test
  public void getNumberOfStreams() {
    assertEquals(0, (int) media.getTimesStreamed());
  }

  @Test
  public void incrementTimesStreamed() {
    media.incrementTimesStreamed();
    assertEquals(1, (int) media.getTimesStreamed());
    media.incrementTimesStreamed();
    media.incrementTimesStreamed();
    media.incrementTimesStreamed();
    assertEquals(4, (int) media.getTimesStreamed());
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
        List<Name> directors, List<Name> mainActors)
        throws NullObjectException, IllegalArgumentException {
      super(alias, title, yearOfRelease, directors, mainActors);
    }
  }
}