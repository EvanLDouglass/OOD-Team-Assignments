package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class DateTest {
  private Date date;

  @Before
  public void setUp() throws Exception {
    date = new Date(1, 2, 2019);
  }

  @Test
  public void getLocalDate() {
    assertEquals(LocalDate.of(2019,2,1), date.getLocalDate());
  }

  @Test
  public void getMonthDuration() {
    assertEquals(5, date.getMonthDuration());
  }

  @Test
  public void getYearDuration() {
    assertEquals(0, date.getYearDuration());
  }

  @Test
  public void getDayDuration() {
    assertEquals(165, date.getDayDuration());
  }

  @Test
  public void equals1() {
    assertTrue(date.equals(date));
    assertFalse(date.equals(null));
  }

  @Test
  public void hashCode1() {
    assertEquals(4135072, date.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals("Date{localDate=2019-02-01}", date.toString());
  }
}