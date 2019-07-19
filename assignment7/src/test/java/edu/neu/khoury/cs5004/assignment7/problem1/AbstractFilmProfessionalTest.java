package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.EmptyNameException;
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.NullObjectException;

import org.junit.Before;
import org.junit.Test;

public class AbstractFilmProfessionalTest {

  private ConcreteFilmProfessional prof;

  @Before
  public void setUp() throws Exception {
    prof = new ConcreteFilmProfessional(new Name("Works", "In", "Film"));
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
  }

  @Test
  public void notEqualsBasic() throws NullObjectException, EmptyNameException {
    assertNotEquals(null, prof);
    assertNotEquals("prof", prof);

    ConcreteFilmProfessional prof1 = new ConcreteFilmProfessional(new Name("Not", "The", "Same"));
    assertNotEquals(prof1, prof);
  }

  @Test
  public void hashCodeEquals() throws NullObjectException, EmptyNameException {
    assertEquals(prof.hashCode(), prof.hashCode());
    ConcreteFilmProfessional prof1 = new ConcreteFilmProfessional(new Name("Works", "In", "Film"));
    assertEquals(prof1.hashCode(), prof.hashCode());
  }

  @Test
  public void hashCodeNotEquals() throws NullObjectException, EmptyNameException {
    ConcreteFilmProfessional prof1 = new ConcreteFilmProfessional(new Name("Works", "In", "Music"));
    assertNotEquals(prof1.hashCode(), prof.hashCode());
  }

  @Test
  public void toString1() {
    String expected = "Works In Film";
    assertEquals(expected, prof.toString());
  }

  /* Helper Class */
  private class ConcreteFilmProfessional extends AbstractFilmProfessional {

    public ConcreteFilmProfessional(Name name) {
      super(name);
    }
  }
}