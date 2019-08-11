package edu.neu.khoury.cs5004.assignment9;

import static junit.framework.TestCase.assertTrue;

import java.io.File;
import org.junit.Before;
import org.junit.Test;

public class SecureBankVerificationSimulatorTest {

  private String[] args;

  @Before
  public void setUp() throws Exception {
    args = new String[]{"25", "100", "30", "./testoutput.csv"};
  }

  @Test
  public void main() {
    SecureBankVerificationSimulator.main(args);
    File output = new File("./testoutput.csv");
    assertTrue(output.exists());
  }
}