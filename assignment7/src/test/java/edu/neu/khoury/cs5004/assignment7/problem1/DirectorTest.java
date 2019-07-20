package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DirectorTest {

  private Director director;

  @Before
  public void setUp() throws Exception {
    director = new Director(new Name("Director", "Person"));
  }

  @Test
  public void toString1() {
    String expected = "Director{Director Person}";
    assertEquals(expected, director.toString());
  }
}