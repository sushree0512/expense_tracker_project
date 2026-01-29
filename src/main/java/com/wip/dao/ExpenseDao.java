package com.wip.dao;

import java.util.List;

import com.wip.model.Expense;

public interface ExpenseDao {
	public void addExpense(Expense expense);
	List<Expense> getAllExpense();
	boolean updateExpense(Expense expense);
	boolean deleteExpense(int id);
	double getTotalExpense();
	Expense getExpenseById(int id);

}
