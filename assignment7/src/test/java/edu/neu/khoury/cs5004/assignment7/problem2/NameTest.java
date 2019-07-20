package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("a", "b");
  }

  @Test
  public void getFirstName() {
    assertEquals("a", name.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("b", name.getLastName());
  }

  @Test
  public void equals1() {
    assertTrue(name.equals(name));
    assertFalse(name.equals(null));

    Name name1 = new Name("a", "b");
    assertEquals(name1, name);
  }



  @Test
  public void toString1() {
    assertEquals("Name{firstName='a', lastName='b'}", name.toString());
  }
}