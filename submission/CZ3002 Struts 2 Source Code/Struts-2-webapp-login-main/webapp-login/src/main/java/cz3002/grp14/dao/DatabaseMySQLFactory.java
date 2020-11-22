package cz3002.grp14.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DatabaseMySQLFactory {

    final String HOSTNAME = "localhost";
    final String PORT = "3306";
    final String SCHEMA = "ase";

    final String DB_USER = "root";
    final String DB_PASSWORD = "toor";

    final String CONNECTION_URL = String.format("jdbc:mysql://%1$s:%2$s/%3$s?serverTimezone=UTC", HOSTNAME, PORT, SCHEMA); // jdbc:mysql://localhost:3306/ase

    private static DatabaseMySQLFactory connFactory = null;

    private DatabaseMySQLFactory() {

    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(CONNECTION_URL);
            conn = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error connecting to Database", ex);
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error", e);
        }
    }

    public static DatabaseMySQLFactory getInstance() {
        if (connFactory == null) {
            connFactory = new DatabaseMySQLFactory();
        }
        return connFactory;
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) throws SQLException {
        Connection conn = new DatabaseMySQLFactory().getInstance().getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");
        while (rs.next()) {
            System.out.println("Username " + rs.getString("USERNAME") +
                    " | PASSWORD " + rs.getString("PASSWORD"));
        }
    }
}
