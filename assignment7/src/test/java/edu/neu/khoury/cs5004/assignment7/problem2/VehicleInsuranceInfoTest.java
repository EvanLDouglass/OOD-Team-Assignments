package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleInsuranceInfoTest {
  private VehicleInsuranceInfo vehicleInsuranceInfo;
  private Name name1;
  private Name name2;
  private List<Name> names;

  @Before
  public void setUp() throws Exception {
    name1 = new Name("a", "a");
    name2 = new Name("b", "b");
    names = new ArrayList<>();
    names.add(name1);
    names.add(name2);
    vehicleInsuranceInfo = new VehicleInsuranceInfo(name1, names, new Date(1,1,1));
  }

  @Test
  public void getOfficialOwner() {
    assertEquals(name1, vehicleInsuranceInfo.getOfficialOwner());
  }

  @Test
  public void getPeopleCoverd() {
    assertEquals(names, vehicleInsuranceInfo.getPeopleCoverd());
  }

  @Test
  public void getExpirationDate() {
    assertEquals(new Date(1,1,1), vehicleInsuranceInfo.getExpirationDate());
  }

  @Test
  public void equals1() {
    assertTrue(vehicleInsuranceInfo.equals(vehicleInsuranceInfo));
    assertFalse(vehicleInsuranceInfo.equals(null));

    VehicleInsuranceInfo info = new VehicleInsuranceInfo(name1, names, new Date(1,1,1));
    assertEquals(info, vehicleInsuranceInfo);
  }

  @Test
  public void toString1() {
    assertEquals("VehicleInsuranceInfo{officialOwner=Name{firstName='a', lastName='a'},"
        + " peopleCoverd=[Name{firstName='a', lastName='a'}, Name{firstName='b', lastName='b'}],"
        + " expirationDate=Date{localDate=0001-01-01}}",vehicleInsuranceInfo.toString());
  }
}