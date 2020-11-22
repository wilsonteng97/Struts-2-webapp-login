package cz3002.grp14.dao;

import cz3002.grp14.dao.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DataAccessObject<User> {
    private List<User> users = new ArrayList<>();

    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public UserDAO() {

    }

    private Connection getConnection() {
        Connection conn;
        conn = DatabaseMySQLFactory.getInstance().getConnection();
        return conn;
    }

    @Override
    public boolean get(User user) {
        try {
            String queryString = String.format("SELECT * FROM user " +
                    "WHERE USERNAME=? AND PASSWORD=?");
            conn = getConnection();
            ptmt = conn.prepareStatement(queryString);
            ptmt.setString(1, user.getUserID());
            ptmt.setString(2, user.getPassword());
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("USERNAME") +
                        " | PASSWORD: " + resultSet.getString("PASSWORD"));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        try {
            users = new ArrayList<>();
            String queryString = "SELECT * FROM user";
            conn = getConnection();
            ptmt = conn.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("USERNAME") +
                        " | PASSWORD: " + resultSet.getString("PASSWORD"));
                users.add(new User(resultSet.getString("USERNAME"), resultSet.getString("PASSWORD")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public void update(User user) {
        try {
            String queryString = "UPDATE user SET PASSWORD=? WHERE USERNAME=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(queryString);
            ptmt.setString(1, user.getPassword());
            ptmt.setString(2, user.getUserID());
            ptmt.executeUpdate();
            System.out.println("User Updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (conn != null)
                    conn.close();
            }

            catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        users.add(user);
    }

    @Override
    public void delete(User user) {
        try {
            if (!this.get(user)) {
                System.out.println("User does not exist");
            }
            String queryString = "DELETE FROM user " +
                            "WHERE USERNAME=? AND PASSWORD=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(queryString);
            ptmt.setString(1, user.getUserID());
            ptmt.setString(2, user.getPassword());
            ptmt.executeUpdate();
            System.out.println("Data deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAO();
        userDAO.getAll();
    }
}
