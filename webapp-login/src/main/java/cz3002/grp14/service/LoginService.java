package cz3002.grp14.service;

import cz3002.grp14.action.LoginAction;
import cz3002.grp14.dao.UserDAO;
import cz3002.grp14.dao.entity.User;

import java.sql.SQLException;

public class LoginService {

    public LoginService() {

    }

    public boolean verifyLogin(User user) {
//        if (user.getUserID().equals("root") && user.getPassword().equals("toor")) {
//            return true;
//        }
        UserDAO userDAO = new UserDAO();
        boolean userVerified = userDAO.get(user);
        System.out.println("userVerified: " + userVerified);
        return userVerified;
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) throws SQLException {
        LoginService loginService = new LoginService();
        System.out.print("Correct Credentials: ");
        System.out.println(loginService.verifyLogin(new User("root", "toor")));
        System.out.print("Wrong Credentials: ");
        System.out.println(loginService.verifyLogin(new User("root", "vdv")));
    }
}
