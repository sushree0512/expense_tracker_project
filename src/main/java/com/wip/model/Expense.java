package com.wip.model;

import java.time.LocalDate;

public class Expense {
	private int id;
	private String name;
	private double amount;
	private LocalDate date;
	private String Category;
	
	
	public Expense() {
		
			}
	
	
public Expense(String name, double amount, LocalDate date, String category) {
		this.name = name;
		this.amount = amount;
		this.date = date;
		Category = category;
	}


//getter and setter methods
	public int getId() {
		return id;
	}
	
	 public void setId(int id) {     
	        this.id = id;
	    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}
	
}
