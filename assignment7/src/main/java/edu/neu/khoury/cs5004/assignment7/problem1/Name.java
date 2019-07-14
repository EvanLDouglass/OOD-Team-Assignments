package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * Defines the characteristics of a name. Includes fields for first, middle and last names. It is
 * assumed that anything with a name cannot have an empty/null name. For things with a single name,
 * that name is classified as a first name.
 *
 * @author evandouglass
 */
public class Name {

  private String firstName;
  private String middleNames;
  private String lastName;

  /* Constructors */

  /**
   * Single name constructor. The given name is stored as a first name.
   *
   * @param name a name
   * @throws NullObjectException if the given name is null
   * @throws EmptyNameException if the given name is empty
   */
  public Name(String name) throws NullObjectException, EmptyNameException {
    this(name, null, null);
  }

  /**
   * Two name constructor.
   *
   * @param firstName a first name
   * @param lastName a last name
   * @throws NullObjectException if first name is null
   * @throws EmptyNameException if first name is empty
   */
  public Name(String firstName, String lastName) throws NullObjectException, EmptyNameException {
    this(firstName, null, lastName);
  }

  /**
   * Three (or more) name constructor.
   *
   * @param firstName a first name
   * @param middleNames a middle name(s)
   * @param lastName a last name
   * @throws NullObjectException if first name is null
   * @throws EmptyNameException if first name is empty
   */
  public Name(String firstName, String middleNames, String lastName)
      throws NullObjectException, EmptyNameException {
    // First name is the default field for Name's with one name, shouldn't be null or empty
    validateFirstName(firstName);
    this.firstName = firstName;
    this.middleNames = middleNames;
    this.lastName = lastName;
  }

  /* Validators */

  /**
   * Validates the first name field to ensure it is non-null and non-empty.
   *
   * @param name the first name to test
   * @throws NullObjectException if the name is null
   * @throws EmptyNameException if the name is empty
   */
  private void validateFirstName(String name) throws NullObjectException, EmptyNameException {
    if (isNameNull(firstName)) {
      throw new NullObjectException("First name cannot be null");
    }
    if (isNameEmpty(firstName)) {
      throw new EmptyNameException("First name cannot be empty");
    }
  }

  /**
   * Tests if the given name is an empty string.
   *
   * @param name a name to test
   * @return true if the name is empty, else false
   */
  private Boolean isNameEmpty(String name) {
    return name.equals("");
  }

  /**
   * Tests if the given name is null.
   *
   * @param name a name to test
   * @return true if the name is null, else false
   */
  private Boolean isNameNull(String name) {
    return name == null;
  }

  /* Methods */

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Name name = (Name) obj;
    return firstName.equals(name.firstName)
        && Objects.equals(middleNames, name.middleNames)
        && Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, middleNames, lastName);
  }

  @Override
  public String toString() {
    return firstName + " " + middleNames + " " + lastName;
  }

  /* Getters and Setters */

  /**
   * Returns the first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets a new, non-null, non-empty first name
   *
   * @param firstName the new first name
   * @throws NullObjectException if the name is null
   * @throws EmptyNameException if the name is empty
   */
  public void setFirstName(String firstName) throws NullObjectException, EmptyNameException {
    validateFirstName(firstName);
    this.firstName = firstName;
  }

  /**
   * Returns the middle name.
   *
   * @return the middle name
   */
  public String getMiddleNames() {
    return middleNames;
  }

  /**
   * Sets a new middle name.
   *
   * @param middleNames the new middle name
   */
  public void setMiddleNames(String middleNames) {
    this.middleNames = middleNames;
  }

  /**
   * Returns the last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets a new last name.
   *
   * @param lastName the new last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
