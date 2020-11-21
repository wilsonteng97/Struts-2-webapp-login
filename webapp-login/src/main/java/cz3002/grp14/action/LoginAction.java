package cz3002.grp14.action;

import com.opensymphony.xwork2.ActionSupport;
import cz3002.grp14.entity.User;
import cz3002.grp14.service.LoginService;
import org.apache.commons.lang3.StringUtils;

public class LoginAction extends ActionSupport {

    private User user;

    @Override
    public void validate() {
        // Fields are blank
        System.out.println("Username: " + user.getUserID() + " | Password: " +  user.getPassword());
//        if (StringUtils.isEmpty(user.getUserID())) { // userID field not entered
//            addFieldError("userID", "Username cannot be blank");
//        }
//        if (StringUtils.isEmpty(user.getPassword())) { // password field not entered
//            addFieldError("password", "Password cannot be blank");
//        }

        if (StringUtils.isEmpty(user.getUserID()) || StringUtils.isEmpty(user.getPassword())) {
            System.out.println("Action Error");
            addActionError("Username & Password cannot be blank");
        }
    }

    public String execute() {
        LoginService loginService = new LoginService();
//        System.out.println(user.getUserID() + " | " +  user.getPassword());
        if (loginService.verifyLogin(user)) {
            System.out.println("=============== Login Success");
            return SUCCESS;
        }
        System.out.println("=============== Login Fail, redirect to login again");
        return LOGIN;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
