package edu.neu.khoury.cs5004.assignment8.dataprocessor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class RecordTest {

  private Record rec1;
  private Record rec2;

  @Before
  public void setUp() throws Exception {
    String[] fields = new String[]{"first_name", "last_name", "email"};
    String[] values = new String[]{"Evan", "Douglass", "douglass.ev@husky.neu.edu"};
    rec1 = new Record(fields, values);

    Map<String, String> map = new HashMap<>();
    map.put("name", "Evan Douglass");
    map.put("birth_date", "December 18 1990");
    rec2 = new Record(map);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorWithDiffLengths() {
    String[] fields = new String[]{"last_name", "email"};
    String[] values = new String[]{"Evan", "Douglass", "douglass.ev@husky.neu.edu"};
    rec1 = new Record(fields, values);
  }

  @Test
  public void getValue() {
    assertEquals("Evan", rec1.getValue("first_name"));
    assertEquals("December 18 1990", rec2.getValue("birth_date"));
  }

  @Test
  public void getFields() {
    Set<String> set1 = new HashSet<>();
    set1.add("first_name");
    set1.add("last_name");
    set1.add("email");

    Set<String> set2 = new HashSet<>();
    set2.add("name");
    set2.add("birth_date");

    assertEquals(set1, rec1.getFields());
    assertEquals(set2, rec2.getFields());
  }

  @Test
  public void equals1() {
    assertEquals(rec1, rec1);

    Map<String, String> map = new HashMap<>();
    map.put("first_name", "Evan");
    map.put("last_name", "Douglass");
    map.put("email", "douglass.ev@husky.neu.edu");
    Record newRec = new Record(map);
    assertEquals(newRec, rec1);
    assertEquals(rec1, newRec);
  }

  @Test
  public void notEquals() {
    assertNotEquals(null, rec1);
    assertNotEquals("record", rec2);
    assertNotEquals(rec2, "record");
    assertNotEquals(rec1, rec2);
    assertNotEquals(rec2, rec1);
  }

  @Test
  public void hashCode1() {
    assertEquals(rec1.hashCode(), rec1.hashCode());

    Map<String, String> map = new HashMap<>();
    map.put("first_name", "Evan");
    map.put("last_name", "Douglass");
    map.put("email", "douglass.ev@husky.neu.edu");
    Record newRec = new Record(map);
    assertEquals(newRec.hashCode(), rec1.hashCode());
    assertEquals(rec1.hashCode(), newRec.hashCode());

    assertNotEquals(rec2.hashCode(), rec1.hashCode());
  }

  @Test
  public void toString1() {
    Map<String, String> same = new HashMap<>();
    same.put("first_name", "Evan");
    same.put("last_name", "Douglass");
    same.put("email", "douglass.ev@husky.neu.edu");
    String expected = "Record" + same.toString();
    assertEquals(expected, rec1.toString());
  }
}