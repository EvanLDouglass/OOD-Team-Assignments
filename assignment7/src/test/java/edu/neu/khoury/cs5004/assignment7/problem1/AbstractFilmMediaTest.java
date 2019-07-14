package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class AbstractFilmMediaTest {

  private ConcreteFilmMedia media;

  @Before
  public void setUp() throws Exception {
  }

  @Test(expected = NullObjectException.class)
  public void nullAlias() {
  }

  @Test(expected = NullObjectException.class)
  public void nullTitle() {
  }

  @Test(expected = NullObjectException.class)
  public void nullYear() {
  }

  @Test(expected = NullObjectException.class)
  public void nullDirectors() {
  }

  @Test(expected = NullObjectException.class)
  public void nullActors() {
  }

  @Test
  public void getAndSetAlias() {

  }

  @Test
  public void toString1() {

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
  public void getTitle() {

  }

  @Test
  public void getYearOfRelease() {

  }

  @Test
  public void getDirectors() {

  }

  @Test
  public void getActors() {

  }

  private class ConcreteFilmMedia extends AbstractFilmMedia {

    public ConcreteFilmMedia(String alias, String title, Integer yearOfRelease,
        List<IDirector> directors, List<IActor> mainActors) throws NullObjectException {
      super(alias, title, yearOfRelease, directors, mainActors);
    }
  }
}