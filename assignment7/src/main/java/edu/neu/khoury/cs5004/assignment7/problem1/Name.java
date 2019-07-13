package edu.neu.khoury.cs5004.assignment7.problem1;

public class Name {

  private String firstName;
  private String middleNames;
  private String lastName;

  /* Constructors */

  public Name(String name) throws NullNameException, EmptyNameException {
    this(name, null, null);
  }

  public Name(String firstName, String lastName) throws NullNameException, EmptyNameException {
    this(firstName, null, lastName);
  }

  public Name(String firstName, String middleNames, String lastName)
      throws NullNameException, EmptyNameException {
    // First name is the default field for Name's with one name, shouldn't be null or empty
    validateNameNotNull(firstName);
    validateNameNotEmpty(firstName);
    // A name can be missing a middle or last name, but if they exist, they should not be empty.
    validateNameNotEmpty(middleNames);
    validateNameNotEmpty(lastName);
    this.firstName = firstName;
    this.middleNames = middleNames;
    this.lastName = lastName;
  }

  /* Validators */

  private void validateNameNotEmpty(String name) throws EmptyNameException {
    if (name.equals("")) {
      throw new EmptyNameException();
    }
  }

  private void validateNameNotNull(String name) throws NullNameException {
    if (name == null) {
      throw new NullNameException();
    }
  }

  /* Getters and Setters */

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) throws NullNameException, EmptyNameException {
    validateNameNotNull(firstName);
    validateNameNotEmpty(firstName);
    this.firstName = firstName;
  }

  public String getMiddleNames() {
    return middleNames;
  }

  public void setMiddleNames(String middleNames) throws EmptyNameException {
    validateNameNotEmpty(middleNames);
    this.middleNames = middleNames;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) throws EmptyNameException {
    validateNameNotEmpty(lastName);
    this.lastName = lastName;
  }
}
