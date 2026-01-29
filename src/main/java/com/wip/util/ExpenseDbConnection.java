package com.wip.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ExpenseDbConnection {
	
	private ExpenseDbConnection() {
		
	}
	
	private static Connection con;
	public static Connection getExpenseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/expensedb",
					"root",
					"Preeti@2003"
					);
			
					System.out.println("Connection Established Successfully: "+ con);
					return con;
		}
		catch(Exception e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
			return null;
		}
		
		
	}

}
