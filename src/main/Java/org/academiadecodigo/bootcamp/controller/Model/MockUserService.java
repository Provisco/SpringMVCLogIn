package org.academiadecodigo.bootcamp.controller.Model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 13/12/16.
 */
public class MockUserService implements UserService {

    private List<User> userList = new ArrayList();

    public MockUserService(){
        userList.add(new User("Pedro", "123", "pedro@pedro.com"));
    }


    @Override
    public boolean authenticate(String username, String password) {
        User tempUser = findByName(username);
        if(tempUser == null){
            System.out.println("User not found");
        }
        if (tempUser.getPassword().equals(password)){
            System.out.println("Login Successful");
            return true;
        }
        System.out.println("Password does not match");
        return false;
    }

    @Override
    public boolean addUser(User user) {
        if(findByName(user.getUsername()) != null){
            System.out.println("User name already taken");
            return false;
        }
        userList.add(user);
        System.out.println("User added successfully");
        return false;
    }

    @Override
    public int count() {
        return userList.size();
    }

    @Override
    public User findByName(String username) {
        for(int i=0; i<userList.size(); i++ ){
            if(userList.get(i).getUsername().equals(username)){
                return userList.get(i);
            }
        }
        System.out.println("User non existent");
        return null;
    }

    @Override
    public void remove(String username) {
        if(findByName(username) != null){
            userList.remove(findByName(username));
        }
    }

    @Override
    public List<User> getUserList(){
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
