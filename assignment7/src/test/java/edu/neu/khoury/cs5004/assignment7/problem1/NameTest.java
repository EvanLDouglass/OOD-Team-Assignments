package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.EmptyNameException;
import edu.neu.khoury.cs5004.assignment7.problem1.exceptions.NullObjectException;
import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Evan", "Lathrop", "Douglass");
  }

  @Test
  public void makeWithOneName() throws NullObjectException, EmptyNameException {
    name = new Name("Evan");
    assertEquals("Evan", name.getFirstName());
  }

  @Test
  public void makeWithTwoNames() throws NullObjectException, EmptyNameException {
    name = new Name("Evan", "Douglass");
    assertEquals("Evan", name.getFirstName());
    assertEquals("Douglass", name.getLastName());
  }

  @Test
  public void makeWithNullFirst() throws EmptyNameException {
    // Single argument
    try {
      name = new Name(null);
      fail("first name cannot be null");
    } catch (NullObjectException e) {
      // passed test
    }
    // middle and last not null
    try {
      name = new Name(null, "middle", "last");
      fail("first name cannot be null");
    } catch (NullObjectException e) {
      // passed test
    }
  }

  @Test
  public void makeWithEmptyFirst() throws NullObjectException {
    // Single argument
    try {
      name = new Name("");
      fail("first name cannot be empty");
    } catch (EmptyNameException e) {
      // passed test
    }
    // Middle and Last are not null
    try {
      name = new Name("", "middle", "last");
      fail("first name cannot be empty");
    } catch (EmptyNameException e) {
      // passed test
    }
  }

  @Test
  public void makeWithEmptyMiddleAndLast() throws NullObjectException, EmptyNameException {
    // also tested in toString tests
    name = new Name("Evan", "", "");
    assertEquals("Evan", name.getFirstName());
  }

  @Test
  public void equalsBasic() throws NullObjectException, EmptyNameException {
    assertEquals(name, name);
    assertEquals(new Name("Evan", "Lathrop", "Douglass"), name);
  }

  @Test
  public void notEqualsBasic() {
    assertNotEquals(null, name);
    assertNotEquals("Name", name);
  }

  @Test
  public void notEquals() throws NullObjectException, EmptyNameException {
    // middle and last are null
    Name name1 = new Name("Evan");
    assertNotEquals(name1, name);
    // middle is null
    name1.setLastName("Douglass");
    assertNotEquals(name1, name);
    // diff. middle
    name1.setMiddleNames("L.");
    assertNotEquals(name1, name);
    // diff. first
    name1.setMiddleNames("Lathrop");
    name1.setFirstName("E.");
    assertNotEquals(name1, name);
    // diff. last
    name1.setFirstName("Evan");
    name1.setLastName("D.");
    assertNotEquals(name1, name);
  }

  @Test
  public void hashCodeEquals() throws NullObjectException, EmptyNameException {
    assertEquals(name.hashCode(), name.hashCode());
    Name name1 = new Name("Evan", "Lathrop", "Douglass");
    assertEquals(name1.hashCode(), name.hashCode());
  }

  @Test
  public void hashCodeNotEquals() throws NullObjectException, EmptyNameException {
    // middle and last are null
    Name name1 = new Name("Evan");
    assertNotEquals(name1.hashCode(), name.hashCode());
    // middle is null
    name1.setLastName("Douglass");
    assertNotEquals(name1.hashCode(), name.hashCode());
    // diff. middle
    name1.setMiddleNames("L.");
    assertNotEquals(name1.hashCode(), name.hashCode());
    // diff. first
    name1.setMiddleNames("Lathrop");
    name1.setFirstName("E.");
    assertNotEquals(name1.hashCode(), name.hashCode());
    // diff. last
    name1.setFirstName("Evan");
    name1.setLastName("D.");
    assertNotEquals(name1.hashCode(), name.hashCode());
  }

  @Test
  public void toStringThreeNames() {
    String expected = "Evan Lathrop Douglass";
    assertEquals(expected, name.toString());
  }

  @Test
  public void toStringTwoNames() throws NullObjectException, EmptyNameException {
    name = new Name("Evan", "Douglass");
    String expected = "Evan Douglass";
    assertEquals(expected, name.toString());
    name = new Name("Evan", "", "Douglass");
    assertEquals(expected, name.toString());
  }

  @Test
  public void toStringOneName() throws NullObjectException, EmptyNameException {
    name = new Name("Evan");
    String expected = "Evan";
    assertEquals(expected, name.toString());
    name = new Name("Evan", "", "");
    assertEquals(expected, name.toString());
  }

  @Test
  public void toStringManyNames() throws NullObjectException, EmptyNameException {
    name = new Name("Mr. John", "Bill Fred", "Newton-Einstein");
    String expected = "Mr. John Bill Fred Newton-Einstein";
    assertEquals(expected, name.toString());
  }

  @Test
  public void getFirstName() {
    assertEquals("Evan", name.getFirstName());
  }

  @Test
  public void setFirstNameSuccessful() throws NullObjectException, EmptyNameException {
    name.setFirstName("Fred");
    assertEquals("Fred", name.getFirstName());
  }

  @Test(expected = NullObjectException.class)
  public void setFirstNameNull() throws NullObjectException, EmptyNameException {
    name.setFirstName(null);
  }

  @Test(expected = EmptyNameException.class)
  public void setFirstNameEmpty() throws NullObjectException, EmptyNameException {
    name.setFirstName("");
  }

  @Test
  public void getAndSetMiddleNames() {
    assertEquals("Lathrop", name.getMiddleNames());
    name.setMiddleNames("Hello");
    assertEquals("Hello", name.getMiddleNames());
    name.setMiddleNames("");
    assertEquals("", name.getMiddleNames());
    name.setMiddleNames(null);
    assertNull(name.getMiddleNames());
  }

  @Test
  public void getAndSetLastName() {
    assertEquals("Douglass", name.getLastName());
    name.setLastName("Hello");
    assertEquals("Hello", name.getLastName());
    name.setLastName("");
    assertEquals("", name.getLastName());
    name.setLastName(null);
    assertNull(name.getLastName());
  }
}