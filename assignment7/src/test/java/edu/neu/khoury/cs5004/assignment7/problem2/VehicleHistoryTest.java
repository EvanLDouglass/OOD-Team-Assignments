package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

public class VehicleHistoryTest {
  private VehicleHistory vehicleHistory;
  private VehicleViolation vehicleViolation;
  private VehicleCrash vehicleCrash;
  private HashSet<VehicleCrash> vehicleCrashes;
  private HashSet<VehicleViolation> vehicleViolations;

  @Before
  public void setUp() throws Exception {
    vehicleViolations = new HashSet<>();
    vehicleCrashes = new HashSet<>();
    vehicleViolation = new VehicleViolation(MovingViolation.SPEEDING, new Name("a", "a"), new Date(1,1,1));
    vehicleCrash = new VehicleCrash(new Name("a", "a"), new Date(1,1,1), Crash.CRASHWITHIINJURIES);
    vehicleCrashes.add(vehicleCrash);
    vehicleViolations.add(vehicleViolation);
    vehicleHistory = new VehicleHistory(vehicleCrashes, vehicleViolations);
  }

  @Test
  public void getCrashes() {
    assertEquals(vehicleCrashes, vehicleHistory.getCrashes());
  }

  @Test
  public void getVehicleViolations() {
    assertEquals(vehicleViolations, vehicleHistory.getVehicleViolations());
  }

  @Test
  public void equals1() {
    assertTrue(vehicleHistory.equals(vehicleHistory));
    assertFalse(vehicleHistory.equals(null));
  }



  @Test
  public void toString1() {
    assertEquals("VehicleHistory{crashes=[VehicleCrash{offendingDriver=Name{firstName='a', lastName='a'},"
        + " offendingDate=Date{localDate=0001-01-01}, crash=CRASHWITHIINJURIES}],"
        + " vehicleViolations=[VehicleViolation{offendingDriver=Name{firstName='a', lastName='a'},"
        + " offendingDate=Date{localDate=0001-01-01}}]}", vehicleHistory.toString());
  }
}