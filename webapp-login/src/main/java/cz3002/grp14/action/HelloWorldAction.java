package cz3002.grp14.action;

import cz3002.grp14.service.MessageService;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

    /** Properties **/
    private String message;

    public String execute() {
        MessageService messageService = new MessageService() ;
        setMessage(messageService.getMessage());
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}