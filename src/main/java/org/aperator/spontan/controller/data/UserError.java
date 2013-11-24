package org.aperator.spontan.controller.data;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 24/11/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class UserError {
    private String message;

    public UserError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
