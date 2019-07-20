package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriverViolationTest {
  DriverViolation driverViolation1;
  DriverViolation driverViolation2;

  @Before
  public void setUp() throws Exception {
    driverViolation1 = new DriverViolation(MovingViolation.SPEEDING);
    driverViolation2 = new DriverViolation(NonMovingViolation.PARKINGVIOLATION);
  }

  @Test
  public void getMovingViolation() {
    assertEquals(MovingViolation.SPEEDING, driverViolation1.getMovingViolation());
  }

  @Test
  public void getNonMovingViolation() {
    assertEquals(NonMovingViolation.PARKINGVIOLATION, driverViolation2.getNonMovingViolation());
  }

  @Test
  public void equals1() {
    assertTrue(driverViolation1.equals(driverViolation1));
    assertFalse(driverViolation1.equals(driverViolation2));
    assertNotEquals(driverViolation1, driverViolation2);
    assertNotEquals(null, driverViolation1);
    DriverViolation violation = new DriverViolation(MovingViolation.SPEEDING);
    assertEquals(driverViolation1, violation);
  }

  @Test
  public void toString1() {
    assertEquals("DriverViolation{movingViolation=SPEEDING, nonMovingViolation=null}", driverViolation1.toString());
    assertEquals("DriverViolation{movingViolation=SPEEDING, nonMovingViolation=null}", driverViolation1.toString());
  }
}