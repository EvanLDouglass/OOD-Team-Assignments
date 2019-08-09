package edu.neu.khoury.cs5004.assignment9.rsa;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageGeneratorTest {

  @Test
  public void generateMessage() {
    assertTrue(MessageGenerator.generateMessage() < (Integer) 3000);
  }
}