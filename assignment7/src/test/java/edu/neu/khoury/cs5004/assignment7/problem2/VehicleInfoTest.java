package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleInfoTest {
  private VehicleInfo vehicleInfo;

  @Before
  public void setUp() throws Exception {
    vehicleInfo = new VehicleInfo("a", "a", new Date(1,1,1), new Name("a", "b"));
  }

  @Test
  public void getMake() {
    assertEquals("a", vehicleInfo.getMake());
  }

  @Test
  public void getModel() {
    assertEquals("a", vehicleInfo.getModel());
  }

  @Test
  public void getYear() {
    assertEquals(new Date(1,1,1),vehicleInfo.getYear());
  }

  @Test
  public void getOfficialOwner() {
    assertEquals(new Name("a", "b"), vehicleInfo.getOfficialOwner());
  }

  @Test
  public void equals1() {
    assertTrue(vehicleInfo.equals(vehicleInfo));
    assertFalse(vehicleInfo.equals(null));
  }

  @Test
  public void hashCode1() {
    assertEquals(3976995, vehicleInfo.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals("VehicleInfo{make='a', model='a', year=Date{localDate=0001-01-01}, officialOwner=Name{firstName='a', lastName='b'}}", vehicleInfo.toString());
  }
}