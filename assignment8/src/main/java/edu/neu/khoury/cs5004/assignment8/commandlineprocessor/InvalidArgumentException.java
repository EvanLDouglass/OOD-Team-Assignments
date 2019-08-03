package edu.neu.khoury.cs5004.assignment8.commandlineprocessor;

public class InvalidArgumentException extends RuntimeException {

  public InvalidArgumentException(String message) {
    super(message);
  }
}
