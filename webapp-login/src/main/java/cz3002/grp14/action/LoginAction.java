package cz3002.grp14.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

    private String userID;
    private String password;

    public String execute() {
        if (getUserID().equals("root") && getPassword().equals("")) {
            System.out.println("=============== Login Success");
            return SUCCESS;
        }
        System.out.println("=============== Login Fail, redirect to login again");
        return LOGIN;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
