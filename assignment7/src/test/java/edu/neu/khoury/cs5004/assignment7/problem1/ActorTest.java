package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ActorTest {

  private Actor actor;

  @Before
  public void setUp() throws Exception {
    actor = new Actor(new Name("Director", "Person"));
  }

  @Test
  public void toString1() {
    String expected = "Actor{Director Person}";
    assertEquals(expected, actor.toString());
  }
}