package com.bank.bank_of_lebanon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Date;

public class ClientsDatabaseManip {

    //Connect to the database
    public boolean connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:database.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public void CreateClientsTable() {

        String url = "jdbc:sqlite:database.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Clients (\n"
                + "	account_nb integer PRIMARY KEY,\n"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL,\n"
                + "	email text NOT NULL,\n"
                + "	phone_nb text NOT NULL,\n"
                + "	address text NOT NULL,\n"
                + "	job text NOT NULL,\n"
                + "	city text NOT NULL,\n"
                + "	status text NOT NULL,\n"
                + "	gender text NOT NULL,\n"
                + "	birthdate date NOT NULL,\n"
                + "	join_date text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Retrieve all data from the Db and implement it into the ObservableList
    public ObservableList<Client> getClientList() throws SQLException {
        ObservableList<Client> cList = FXCollections.observableArrayList();

        String url = "jdbc:sqlite:database.db";
        // create a connection to the database
        Connection con = DriverManager.getConnection(url);

        String query = "SELECT * FROM Clients";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Client c = new Client();
                c.setAccNb(rs.getInt("account_nb"));
                c.setFirstname(rs.getString("first_name"));
                c.setLastname(rs.getString("last_name"));
                c.setEmail(rs.getString("email"));
                c.setTelephone(rs.getString("phone_nb"));
                c.setAddress(rs.getString("address"));
                c.setJob(rs.getString("job"));
                c.setCity(rs.getString("city"));
                c.setMarried(rs.getString("status"));
                c.setGender(rs.getString("gender"));
                c.setBirthdate(rs.getString("birthdate"));
                c.setToday(rs.getString("join_date"));

                cList.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return cList;
    }
    //Delete Client from the Database
    public void DeleteClient(Client c) throws SQLException {

        String url = "jdbc:sqlite:database.db";

        // create a connection to the database
        Connection con = DriverManager.getConnection(url);
        //Add a query
        String query = "   DELETE FROM Clients " + "WHERE account_nb = " + c.getAccNb() + ";";
        try (Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //insert Client into the Database
    public void InsertClient(int acc_nb, String fname, String lname,String email, String phone,
                             String address,String job, String city, String status, String gender, String birthdate,String join_date
                             ) throws SQLException {

        String url = "jdbc:sqlite:database.db";

        // create a connection to the database
        Connection con = DriverManager.getConnection(url);
        //Add a query
        String query = "INSERT INTO Clients VALUES(" + acc_nb + "," + "'" + fname + "'" + "," + "'" + lname + "'" + "," + "'" + email + "'"
                + "," + "'" + phone + "'" + "," + "'" + address + "'" + "," + "'" + job + "'" + "," + "'" + city + "'" + "," + "'" + status + "'"
                + "," + "'" + gender + "'" + "," + "'" + birthdate + "'" + "," + "'" + join_date + "'" +")";
        try (Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    //Update Client through account nb
    public void UpdateStringClient(String column,String value, int accNb) throws SQLException {

        String url = "jdbc:sqlite:database.db";

        // create a connection to the database
        Connection con = DriverManager.getConnection(url);
        //Add a query
        String query = "UPDATE Clients " + "SET " + column + " =" + "'" + value + "'" + " WHERE account_nb in (" + accNb + ")";

        try (Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}

