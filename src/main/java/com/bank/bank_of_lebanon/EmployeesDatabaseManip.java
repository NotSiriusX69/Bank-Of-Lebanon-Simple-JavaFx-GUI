package com.bank.bank_of_lebanon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeesDatabaseManip {

    private List<Employee> employees = new ArrayList<Employee>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public boolean isIdExist(String acc_id) throws SQLException {

        String url = "jdbc:sqlite:database.db";
        // create a connection to the database
        Connection con = DriverManager.getConnection(url);

        String query = "SELECT emp_id "
                +" FROM Employees WHERE emp_id = " + "'" + acc_id + "'";

        String account;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                account = rs.getString("emp_id");
                if(account.equals(acc_id))
                    return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean isPasswordExist(String password) throws SQLException {

        String url = "jdbc:sqlite:database.db";
        // create a connection to the database
        Connection con = DriverManager.getConnection(url);

        String query = "SELECT password "
                +" FROM Employees WHERE password = " + "'" + password + "'";

        String account;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                account = rs.getString("password");
                if(account.equals(password))
                    return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    public void FillEmployeesArray() throws SQLException {

        String url = "jdbc:sqlite:database.db";
        // create a connection to the database
        Connection con = DriverManager.getConnection(url);

        String query = "SELECT emp_id, email, password FROM Employees";

        Employee emp = new Employee();

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                emp.setId(rs.getString("emp_id"));
                emp.setEmail(rs.getString("email"));
                emp.setPassword(rs.getString("password"));
                employees.add(emp);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
