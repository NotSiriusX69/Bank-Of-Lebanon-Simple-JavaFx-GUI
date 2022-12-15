package com.bank.bank_of_lebanon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class AccountsDatabaseManip {

   public ObservableList<Account> getAccountList() throws SQLException, ClassNotFoundException {
        ObservableList<Account> aList = FXCollections.observableArrayList();

        String url = "jdbc:sqlite:database.db";
        // create a connection to the database
        Connection con = DriverManager.getConnection(url);

        String query = "SELECT * FROM Accounts";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Account a = new Account();

                a.setAccount_number(rs.getInt("account_id"));
                a.setBalance(rs.getDouble("money"));
                a.setIsLoan(rs.getBoolean("isLoan"));
                a.setLoan_amount(rs.getDouble("LoanAmount"));
                a.setIsInterest(rs.getBoolean("isInterest"));
                a.setInterest_amount(rs.getDouble("InterestAmount"));

                aList.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return aList;
    }
   public void CreateAccountsTable() {

        String url = "jdbc:sqlite:database.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Accounts (\n"
                + " account_id integer PRIMARY KEY,\n"
                + "	money double NOT NULL,\n"

                + "	isLoan blob NOT NULL,\n"
                + "	LoanAmount double ,\n"
                + " isLoanEndDate date,\n"

                + "	isInterest blob NOT NULL,\n"
                + "	InterestAmount double,\n"
                + "	InterestEndDate date ,\n"

                + "	money double NOT NULL,\n"
                + " FOREIGN KEY(account_id)\n"
                + " REFERENCES Clients(account_nb)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   public void InsertAccount(int acc_nb, double balance,boolean isLoan, double loan_amount
            , boolean isInterest, double interest_amount) throws SQLException {

        String url = "jdbc:sqlite:database.db";

        // create a connection to the database
        Connection con = DriverManager.getConnection(url);
        //Add a query
        String query = "INSERT INTO Accounts VALUES  ( " + acc_nb + "," +  balance + "," +  isLoan + "," +  loan_amount + "," +
                isInterest + "," +  interest_amount + ")";

        try (Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
   public void DeleteAccount(Client c) throws SQLException {

        String url = "jdbc:sqlite:database.db";

        // create a connection to the database
        Connection con = DriverManager.getConnection(url);
        //Add a query
        String query = "   DELETE FROM Accounts " + "WHERE account_id = " + c.getAccNb() + ";";
        try (Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
   public boolean GetBoolean(String Type, int acc_id) throws SQLException {

        String url = "jdbc:sqlite:database.db";
        // create a connection to the database
        Connection con = DriverManager.getConnection(url);

        String query = "SELECT " + Type
                      +" FROM Accounts WHERE account_id = " + acc_id;

       boolean value = false;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                value = rs.getBoolean(Type);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return value;
    }
   public boolean isIdExist(int acc_id) throws SQLException {

        String url = "jdbc:sqlite:database.db";
        // create a connection to the database
        Connection con = DriverManager.getConnection(url);

        String query = "SELECT account_id "
                +" FROM Accounts WHERE account_id = " + acc_id;

        int account;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                account = rs.getInt("account_id");
                if(account == acc_id)
                    return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
   public void UpdateBooleanAccount(String column, boolean value, int accNb) throws SQLException {

        String url = "jdbc:sqlite:database.db";

        // create a connection to the database
        Connection con = DriverManager.getConnection(url);
        //Add a query
        String query = "UPDATE Accounts " + "SET " + column + " =" + value + " WHERE account_id in (" + accNb + ")";

        try (Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
   public void UpdateDoubleAccount(String column, double value, int accNb) throws SQLException {

        String url = "jdbc:sqlite:database.db";

        // create a connection to the database
        Connection con = DriverManager.getConnection(url);
        //Add a query
        String query = "UPDATE Accounts " + "SET " + column + " ="  + value +  " WHERE account_id in (" + accNb + ")";

        try (Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
   public double GetDouble(String Type, int acc_id) throws SQLException {

        String url = "jdbc:sqlite:database.db";
        // create a connection to the database
        Connection con = DriverManager.getConnection(url);

        String query = "SELECT " + Type
                +" FROM Accounts WHERE account_id = " + acc_id;

        double value = 0;

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                value = rs.getDouble(Type);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return value;
   }
}
