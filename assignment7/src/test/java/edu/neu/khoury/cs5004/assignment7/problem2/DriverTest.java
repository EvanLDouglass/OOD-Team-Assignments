package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {
  private Driver driver;
  private Name driverName;
  private Date driverBirthday;
  private License driverLicenseInformation;
  private VehicleInfo vehicleInformation;
  private VehicleInsuranceInfo vehicleInsuranceInformation;
  private DriverHistory driverHistory;
  private VehicleHistory vehicleHistory;
  private Name name1;
  private Name name2;
  private List<Name> names;
  private VehicleViolation vehicleViolation;
  private VehicleCrash vehicleCrash;
  private HashSet<VehicleCrash> vehicleCrashes;
  private HashSet<VehicleViolation> vehicleViolations;
  private HashSet<DriverViolation> violations;
  private DriverViolation driverViolation;


  @Before
  public void setUp() throws Exception {
    driverName = new Name("a", "a");
    driverBirthday = new Date(1,1,1);
    driverLicenseInformation = new License(1, new Name("a", "b"),
        new Date(1, 1,1), "US",
        new Date(1, 1, 1), new Date(1,1,1));
    vehicleInformation = new VehicleInfo("a", "a",
        new Date(1,1,1), new Name("a", "b"));
    name1 = new Name("a", "a");
    name2 = new Name("b", "b");
    names = new ArrayList<>();
    names.add(name1);
    names.add(name2);
    vehicleInsuranceInformation = new VehicleInsuranceInfo(name1, names, new Date(1,1,1));
    vehicleViolations = new HashSet<>();
    vehicleCrashes = new HashSet<>();
    vehicleViolation = new VehicleViolation(MovingViolation.SPEEDING, new Name("a", "a"), new Date(1,1,1));
    vehicleCrash = new VehicleCrash(new Name("a", "a"), new Date(1,1,1), Crash.CRASHWITHIINJURIES);
    vehicleCrashes.add(vehicleCrash);
    vehicleViolations.add(vehicleViolation);
    vehicleHistory = new VehicleHistory(vehicleCrashes, vehicleViolations);
    violations = new HashSet<>();
    driverViolation = new DriverViolation(MovingViolation.SPEEDING);
    violations.add(driverViolation);
    driverHistory = new DriverHistory(violations);
    driver = new Driver(driverName, driverBirthday,
        driverLicenseInformation,
        vehicleInformation,
        vehicleInsuranceInformation,
        driverHistory,
        vehicleHistory);
  }

  @Test
  public void getDriverName() {
    assertEquals(driverName, driver.getDriverName());
  }

  @Test
  public void getDriverBirthday() {
    assertEquals(driverBirthday, driver.getDriverBirthday());
  }

  @Test
  public void getDriverLicenseInformation() {
    assertEquals(driverLicenseInformation, driver.getDriverLicenseInformation());
  }

  @Test
  public void getVehicleInformation() {
    assertEquals(vehicleInformation, driver.getVehicleInformation());
  }

  @Test
  public void getVehicleInsuranceInformation() {
    assertEquals(vehicleInsuranceInformation, driver.getVehicleInsuranceInformation());
  }

  @Test
  public void getDriverHistory() {
    assertEquals(driverHistory, driver.getDriverHistory());
  }

  @Test
  public void getVehicleHistory() {
    assertEquals(vehicleHistory, driver.getVehicleHistory());
  }

  @Test
  public void equals1() {
    assertTrue(driver.equals(driver));
    assertFalse(driver.equals(null));

    Driver driver1 = new Driver(driverName, driverBirthday,
        driverLicenseInformation,
        vehicleInformation,
        vehicleInsuranceInformation,
        driverHistory,
        vehicleHistory);
  }

  @Test
  public void toString1() {
    assertEquals("Driver{driverName=Name{firstName='a', lastName='a'},"
        + " driverBirthday=Date{localDate=0001-01-01},"
        + " driverLicenseInformation=License{licenseNumber=1, driverName=Name{firstName='a', lastName='b'},"
        + " driverBirthdate=Date{localDate=0001-01-01}, cuntryOrStateOfIssuance='US', expirationDate=Date{localDate=0001-01-01},"
        + " issuanceDate=Date{localDate=0001-01-01}}, vehicleInformation=VehicleInfo{make='a', model='a', year=Date{localDate=0001-01-01},"
        + " officialOwner=Name{firstName='a', lastName='b'}}, vehicleInsuranceInformation=VehicleInsuranceInfo{officialOwner=Name{firstName='a', lastName='a'},"
        + " peopleCoverd=[Name{firstName='a', lastName='a'}, Name{firstName='b', lastName='b'}], expirationDate=Date{localDate=0001-01-01}},"
        + " driverHistory=DriverHistory{violations=[DriverViolation{movingViolation=SPEEDING, nonMovingViolation=null}]},"
        + " vehicleHistory=VehicleHistory{crashes=[VehicleCrash{offendingDriver=Name{firstName='a', lastName='a'},"
        + " offendingDate=Date{localDate=0001-01-01}, crash=CRASHWITHIINJURIES}],"
        + " vehicleViolations=[VehicleViolation{offendingDriver=Name{firstName='a', lastName='a'},"
        + " offendingDate=Date{localDate=0001-01-01}}]}}", driver.toString());
  }
}