package cz3002.grp14.service;

import cz3002.grp14.entity.User;

public class LoginService {
    private String message;

    public LoginService() {

    }

    public boolean verifyLogin(User user) {
        if (user.getUserID().equals("root") && user.getPassword().equals("toor")) {
            return true;
        }
        return false;
    }
}
