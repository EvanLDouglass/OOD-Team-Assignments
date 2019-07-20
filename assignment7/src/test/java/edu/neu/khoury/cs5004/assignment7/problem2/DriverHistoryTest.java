package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

public class DriverHistoryTest {
  private DriverHistory driverHistory;
  private HashSet<DriverViolation> violations;
  private DriverViolation driverViolation;

  @Before
  public void setUp() throws Exception {
    violations = new HashSet<>();
    driverViolation = new DriverViolation(MovingViolation.SPEEDING);
    violations.add(driverViolation);
    driverHistory = new DriverHistory(violations);
  }

  @Test
  public void getViolations() {
    assertEquals(violations, driverHistory.getViolations());
  }

  @Test
  public void equals1() {
    assertTrue(driverHistory.equals(driverHistory));
    assertFalse(driverHistory.equals(null));
  }


  @Test
  public void toString1() {
    assertEquals("DriverHistory{violations=[DriverViolation{movingViolation=SPEEDING,"
        + " nonMovingViolation=null}]}", driverHistory.toString());
  }
}