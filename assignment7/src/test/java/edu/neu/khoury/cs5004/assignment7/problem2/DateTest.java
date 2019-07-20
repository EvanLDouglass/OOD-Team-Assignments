package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class DateTest {
  private Date date;

  @Before
  public void setUp() throws Exception {
    date = new Date(1, 1, 2019);
  }

  @Test
  public void getLocalDate() {
    assertEquals(LocalDate.of(2019,1,1), date.getLocalDate());
  }

  @Test
  public void getMonthDuration() {
    assertEquals(6, date.getMonthDuration());
  }

  @Test
  public void getYearDuration() {
    assertEquals(0, date.getYearDuration());
  }

  @Test
  public void getDayDuration() {
    assertEquals(LocalDate.now().getDayOfYear() - 1, date.getDayDuration());
  }

  @Test
  public void equals1() {
    assertTrue(date.equals(date));
    assertFalse(date.equals(null));

    Date date1 = new Date(1, 1, 2019);
    assertEquals(date1, date);
  }

  @Test
  public void hashCode1() {
    assertEquals(date.hashCode(), date.hashCode());
    Date date1 = new Date(1, 1, 2019);
    assertEquals(date1.hashCode(), date.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals("Date{localDate=2019-01-01}", date.toString());
  }
}