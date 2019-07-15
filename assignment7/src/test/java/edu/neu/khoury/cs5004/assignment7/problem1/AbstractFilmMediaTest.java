package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AbstractFilmMediaTest {

  private ConcreteFilmMedia media;
  private List<Actor> actList;
  private List<Director> dirList;

  @Before
  public void setUp() throws Exception {
    // Make actors
    Actor act1 = new Actor(new Name("Actor", "Number", "1"));
    Actor act2 = new Actor(new Name("Actor", "Number", "2"));
    actList = new ArrayList<>();
    actList.add(act1);
    actList.add(act2);
    // Make director
    Director director = new Director(new Name("Director"));
    dirList = new ArrayList<>();
    dirList.add(director);
    // Make film media
    media = new ConcreteFilmMedia("movie", "Movie Title", 1990, dirList, actList);

    // Ensure data integrity
    act1.addMedia((IFilmMedia) this);
    act2.addMedia((IFilmMedia) this);
    director.addMedia((IFilmMedia) this);
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

  }

  @Test
  public void toStringEmptyList() {

  }

  @Test
  public void equalsBasic() {

  }

  @Test
  public void equalsMain() {

  }

  @Test
  public void notEqualsBasic() {

  }

  @Test
  public void hashCode1() {

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

    public ConcreteFilmMedia(String alias, String title, Integer yearOfRelease,
        List<Director> directors, List<Actor> mainActors) throws NullObjectException {
      super(alias, title, yearOfRelease, directors, mainActors);
    }
  }
}