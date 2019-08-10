package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.*;

import edu.neu.khoury.cs5004.assignment9.MessageGenerator;
import org.junit.Test;

public class MessageGeneratorTest {

  @Test
  public void generateMessage() {
    for (int i = 0; i < 1000; i++) {
      Integer msg = MessageGenerator.generateMessage();
      assertTrue(msg <= (Integer) 3000);
      assertTrue(msg >= (Integer) 0);
    }
  }
}