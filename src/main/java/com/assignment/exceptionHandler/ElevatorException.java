package com.assignment.exceptionHandler;

public class ElevatorException extends RuntimeException {
  private String message;

public ElevatorException(String message) {
	super();
	this.message = message;
}
}
