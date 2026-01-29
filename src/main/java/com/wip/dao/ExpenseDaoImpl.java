package com.wip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wip.model.Expense;
import com.wip.util.ExpenseDbConnection;

public class ExpenseDaoImpl implements ExpenseDao {

    private Connection con;

    public ExpenseDaoImpl() {
        con = ExpenseDbConnection.getExpenseConnection();
    }

    //--------------------ADD EXPENSE------------------------
    @Override
    public void addExpense(Expense expense) {
        String sql = "INSERT INTO expensedata (expense_date, name, amount, category) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(expense.getDate()));
            ps.setString(2, expense.getName());
            ps.setDouble(3, expense.getAmount());
            ps.setString(4, expense.getCategory());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //--------------------GET ALL EXPENSE-------------------
    @Override
    public List<Expense> getAllExpense() {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expensedata";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Expense e = new Expense();
                e.setId(rs.getInt("id"));
                e.setDate(rs.getDate("expense_date").toLocalDate());
                e.setName(rs.getString("name"));
                e.setAmount(rs.getDouble("amount"));
                e.setCategory(rs.getString("category"));
                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //--------------------GET EXPENSE BY ID-------------------
    public Expense getExpenseById(int id) {
        String sql = "SELECT * FROM expensedata WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Expense e = new Expense();
                    e.setId(rs.getInt("id"));
                    e.setDate(rs.getDate("expense_date").toLocalDate());
                    e.setName(rs.getString("name"));
                    e.setAmount(rs.getDouble("amount"));
                    e.setCategory(rs.getString("category"));
                    return e;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //--------------------UPDATE EXPENSE-------------------
    @Override
    public boolean updateExpense(Expense expense) {
        String sql = "UPDATE expensedata SET expense_date=?, name=?, amount=?, category=? WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(expense.getDate()));
            ps.setString(2, expense.getName());
            ps.setDouble(3, expense.getAmount());
            ps.setString(4, expense.getCategory());
            ps.setInt(5, expense.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //--------------------DELETE EXPENSE-------------------
    @Override
    public boolean deleteExpense(int id) {
        String sql = "DELETE FROM expensedata WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //--------------------TOTAL EXPENSE-------------------
    @Override
    public double getTotalExpense() {
        String sql = "SELECT SUM(amount) FROM expensedata";
        double total = 0;
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
