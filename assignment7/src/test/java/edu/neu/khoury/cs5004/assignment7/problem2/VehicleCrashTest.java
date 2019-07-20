package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleCrashTest {
  private VehicleCrash vehicleCrash;

  @Before
  public void setUp() throws Exception {
    vehicleCrash = new VehicleCrash(new Name("a", "a"), new Date(1, 2, 3), Crash.CRASHWITHIINJURIES);
  }

  @Test
  public void getOffendingDriver() {
    assertEquals(new Name("a", "a"), vehicleCrash.getOffendingDriver());
  }

  @Test
  public void getOffendingDate() {
    assertEquals(new Date(1, 2, 3), vehicleCrash.getOffendingDate());
  }

  @Test
  public void getCrash() {
    assertEquals(Crash.CRASHWITHIINJURIES, vehicleCrash.getCrash());
  }

  @Test
  public void equals1() {
    assertTrue(vehicleCrash.equals(vehicleCrash));
    assertFalse(vehicleCrash.equals(null));

    VehicleCrash vehicleCrash1 = new VehicleCrash(new Name("a", "a"), new Date(1, 2, 3), Crash.CRASHWITHIINJURIES);
    assertEquals(vehicleCrash1, vehicleCrash);
  }

  @Test
  public void toString1() {
    assertEquals("VehicleCrash{offendingDriver=Name{firstName='a', lastName='a'},"
        + " offendingDate=Date{localDate=0003-02-01}, crash=CRASHWITHIINJURIES}", vehicleCrash.toString());
  }
}