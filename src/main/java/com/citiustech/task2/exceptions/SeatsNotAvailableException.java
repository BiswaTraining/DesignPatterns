package com.citiustech.task2.exceptions;

public class SeatsNotAvailableException extends Exception{
	public SeatsNotAvailableException(String errMsg) {
		super(errMsg);
	}
}
