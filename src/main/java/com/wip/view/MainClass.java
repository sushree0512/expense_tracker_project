package com.wip.view;

import java.util.Scanner;

import com.wip.controller.ExpenseController;
import com.wip.controller.ExpenseInterface;

public class MainClass {

		public static void main(String[] args) {
			System.out.println("WELCOME TO EXPENSE TRACKER");
			
			ExpenseInterface ex = new ExpenseController();
			Scanner sc = new Scanner(System.in);
			String ch = null;
		
		do {
			System.out.println("1. Add Expense");
			System.out.println("2. View Expense");
			System.out.println("3. Update Expense");
			System.out.println("4. Delete Expense");
			System.out.println("5. Total Expense");
			System.out.println("6. Exit");
			System.out.println("ENTER YOUR CHOICE:");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:{
				ex.addExpense();
				break;
			}
			case 2:{
				ex.viewExpense();
				break;
			}
			case 3:{
				ex.updateExpense();
				break;
			}
			case 4:{
				ex.deleteExpense();
				break;
			}
			case 5:{
				ex.totalExpense();
				break;
			}
			default:{
				System.out.println("Invalid Choice");
			}
		}			
			System.out.println("Do you want to continue?(Y/N)");
			ch = sc.next();
		}while(ch.equals("Y") || ch.equals("y"));
		System.out.println("Thank you for using Expense Tracker Application");
		System.exit(0);
}
			
}
