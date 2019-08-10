package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArgsValidatorTest {
  private ArgsValidator argsValidator;
  private String[] givenArgs;

  @Before
  public void setUp() throws Exception {
    givenArgs = new String[]{"10000", "500", "50", "outputfile"};
    argsValidator = new ArgsValidator();
    argsValidator.processArgument(givenArgs);
  }

  @Test
  public void getNumberOfClients() {
    assertEquals((Integer)10000, argsValidator.getNumberOfClients());
  }

  @Test
  public void getNumberOfVerification() {
    assertEquals((Integer)500, argsValidator.getNumberOfVerification());
  }

  @Test
  public void getPercentageOfInvalidMessage() {
    assertEquals((Integer)50, argsValidator.getPercentageOfInvalidMessage());
  }

  @Test
  public void getOutputFile() {
    assertEquals("outputfile", argsValidator.getOutputFile());
  }

  @Test
  public void equals1() {
    String[] newgivenArgs = new String[]{"10000", "500", "50", "outputfile"};
    ArgsValidator newargsValidator = new ArgsValidator();
    newargsValidator.processArgument(givenArgs);
    assertFalse(argsValidator.equals(null));
    assertTrue(argsValidator.equals(argsValidator));
    assertTrue(argsValidator.equals(newargsValidator));
    assertFalse(argsValidator.equals(1));
  }

  @Test
  public void hashCode1() {
    assertEquals(-974006416, argsValidator.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals("ArgsValidator{numberOfClients=10000, numberOfVerification=500,"
        + " percentageOfInvalidMessage=50, outputFile='outputfile'}", argsValidator.toString());
  }

  @Test
  public void processArgument() {
    String[] wrongGivenArgs = new String[]{"1000000", "500", "50", "outputfile"};
    try {
      argsValidator.processArgument(wrongGivenArgs);
    }catch (InvalidArgumentException e) {
    }

  }

  @Test
  public void checkArgLengh() {
    String[] wrongGivenArgs = new String[]{"100", "500", "50"};
    try {
      argsValidator.processArgument(wrongGivenArgs);
    }catch (InvalidArgumentException e) {
    }
  }
}