package edu.neu.khoury.cs5004.assignment9;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimulatorRandomTest {

  private static final int MAX_MSG = 30000;
  private static final int MAX_WITHDRAW = 3000;
  private static final int MAX_DEPOSIT = 2000;

  @Test
  public void generateMessage() {
    for (int i = 0; i < 1000; i++) {
      Integer msg = SimulatorRandom.generateMessage();
      assertTrue(msg <= (Integer) MAX_MSG);
      assertTrue(msg >= (Integer) 0);
    }
  }

  @Test
  public void generateWithdrawLimit() {
    for (int i = 0; i < 1000; i++) {
      Integer limit = SimulatorRandom.generateWithdrawLimit();
      assertTrue(limit <= (Integer) MAX_WITHDRAW);
      assertTrue(limit >= (Integer) 0);
    }
  }

  @Test
  public void generateDepositLimit() {
    for (int i = 0; i < 1000; i++) {
      Integer limit = SimulatorRandom.generateDepositLimit();
      assertTrue(limit <= (Integer) MAX_DEPOSIT);
      assertTrue(limit >= (Integer) 0);
    }
  }
}