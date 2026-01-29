package com.wip.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.wip.dao.ExpenseDao;
import com.wip.dao.ExpenseDaoImpl;
import com.wip.model.Expense;

public class ExpenseController implements ExpenseInterface {

    private Scanner sc = new Scanner(System.in);
    private ExpenseDao dao = new ExpenseDaoImpl();

    //----------------------------ADD EXPENSE---------------------------------------------
    @Override
    public void addExpense() {
        Expense expense = new Expense();

        System.out.println("Enter Date (YYYY-MM-DD):");
        String dateStr = sc.nextLine();
        expense.setDate(LocalDate.parse(dateStr));

        System.out.println("Enter Expense Name:");
        expense.setName(sc.nextLine());

        System.out.println("Enter Expense Amount:");
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number:");
            sc.next();
        }
        expense.setAmount(sc.nextDouble());
        sc.nextLine(); // consume leftover newline

        System.out.println("Enter Expense Category (Needs, Wants, Savings):");
        expense.setCategory(sc.nextLine());

        dao.addExpense(expense);
        System.out.println("Expense added successfully.");
    }

    //----------------------------VIEW EXPENSE---------------------------------------------
    @Override
    public void viewExpense() {
        List<Expense> expenseList = dao.getAllExpense();

        if (expenseList.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("Here are the expense details:");
        for (Expense e : expenseList) {
            System.out.println(
                "ID: " + e.getId() +
                " | Date: " + e.getDate() +
                " | Name: " + e.getName() +
                " | Amount: " + e.getAmount() +
                " | Category: " + e.getCategory()
            );
        }
    }

    //----------------------------UPDATE EXPENSE---------------------------------------------
    @Override
    public void updateExpense() {
        System.out.println("Enter Expense ID to update:");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        Expense expense = dao.getExpenseById(id);
        if (expense == null) {
            System.out.println("Expense ID not found.");
            return;
        }

        System.out.println("Enter new Date (YYYY-MM-DD):");
        expense.setDate(LocalDate.parse(sc.nextLine()));

        System.out.println("Enter new Name:");
        expense.setName(sc.nextLine());

        System.out.println("Enter new Amount:");
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number:");
            sc.next();
        }
        expense.setAmount(sc.nextDouble());
        sc.nextLine();

        System.out.println("Enter new Category:");
        expense.setCategory(sc.nextLine());

        boolean updated = dao.updateExpense(expense);
        if (updated) {
            System.out.println("Expense updated successfully in database.");
        } else {
            System.out.println("Update failed.");
        }
    }

    //----------------------------DELETE EXPENSE---------------------------------------------
    @Override
    public void deleteExpense() {
        System.out.println("Enter Expense ID to delete:");
        int id = sc.nextInt();
        sc.nextLine();

        boolean deleted = dao.deleteExpense(id);
        if (deleted) {
            System.out.println("Expense deleted successfully from database.");
        } else {
            System.err.println("Expense ID not found.");
        }
    }

    //----------------------------TOTAL EXPENSE---------------------------------------------
    @Override
    public void totalExpense() {
        double total = dao.getTotalExpense();
        System.out.println("Total expense from database = " + total);
    }
}
