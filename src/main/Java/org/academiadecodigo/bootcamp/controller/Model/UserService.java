package org.academiadecodigo.bootcamp.controller.Model;

import java.util.List;

/**
 * Created by codecadet on 13/12/16.
 */
public interface UserService {

    boolean authenticate(String username, String password);

    boolean addUser(User user);

    int count();

    User findByName(String username);

    void remove(String username);

    List<User> getUserList();

}
