package org.academiadecodigo.bootcamp.controller.authenticate;

import org.academiadecodigo.bootcamp.controller.Model.MockUserService;
import org.academiadecodigo.bootcamp.controller.Model.User;
import org.academiadecodigo.bootcamp.controller.Model.UserService;

/**
 * Created by codecadet on 13/12/16.
 */
public class Authenticator {
    private UserService userService;
    private User user;

    public boolean authenticate (String username, String password) {
        if(userService.findByName(username) != null) {
            return true;
        }
        return false;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
