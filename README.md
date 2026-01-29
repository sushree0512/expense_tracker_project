# Expense Tracker 

Expense Tracker is a backend-based application that helps users track, manage, and organize their daily expenses. It allows users to add, update, delete, and view expenses, making personal finance management simple and efficient.


#  Features
- Add new expenses
- Update existing expenses
- Delete expenses
- View all recorded expenses



# Tech Stack

- **Programming Language:** Java (Core Java)
- **Build Tool:** Maven
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **Version Control:** Git

---

# Database Table
CREATE TABLE expenses (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100),
  category VARCHAR(50),
  amount DOUBLE,
  expense_date DATE
);

