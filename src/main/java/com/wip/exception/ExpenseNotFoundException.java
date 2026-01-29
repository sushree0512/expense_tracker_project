package com.wip.exception;

public class ExpenseNotFoundException extends Exception{
	public ExpenseNotFoundException() {
		super();
	}
	public ExpenseNotFoundException(String message) {
		super(message);
		System.out.println("ExpenseNotFound: " + message);
	}
}
