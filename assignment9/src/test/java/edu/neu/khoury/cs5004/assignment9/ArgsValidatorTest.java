package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ArgsValidatorTest {

  private ArgsValidator argsValidator;
  private String[] givenArgs;

  @Before
  public void setUp() throws Exception {
    givenArgs = new String[]{"10000", "500", "50", "outputfile"};
    argsValidator = new ArgsValidator();
    argsValidator.processArguments(givenArgs);
  }

  @Test
  public void getNumberOfClients() {
    assertEquals((Integer) 10000, argsValidator.getNumberOfClients());
  }

  @Test
  public void getNumberOfVerification() {
    assertEquals((Integer) 500, argsValidator.getNumberOfVerification());
  }

  @Test
  public void getPercentageOfInvalidMessage() {
    assertEquals((Integer) 50, argsValidator.getPercentageOfInvalidMessage());
  }

  @Test
  public void getOutputFile() {
    assertEquals("outputfile", argsValidator.getOutputFile());
  }

  @Test
  public void processArgument() {
    String[] wrongGivenArgs = new String[]{"1000000", "500", "50", "outputfile"};
    try {
      argsValidator.processArguments(wrongGivenArgs);
    } catch (InvalidArgumentException e) {
    }

  }

  @Test
  public void checkArgLengh() {
    String[] wrongGivenArgs = new String[]{"100", "500", "50"};
    try {
      argsValidator.processArguments(wrongGivenArgs);
    } catch (InvalidArgumentException e) {
    }
  }
}