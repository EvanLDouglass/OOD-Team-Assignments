package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

/**
 * The type Name.
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Instantiates a new Name.
   *
   * @param firstName the first name
   * @param lastName the last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Name name = (Name) other;
    return Objects.equals(firstName, name.firstName)
        &&
        Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return "Name{"
        +
        "firstName='"
        + firstName
        + '\''
        +
        ", lastName='"
        + lastName
        + '\''
        +
        '}';
  }
}
