package org.academiadecodigo.bootcamp.controller.Controller;

import org.academiadecodigo.bootcamp.controller.Model.User;
import org.academiadecodigo.bootcamp.controller.Model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by codecadet on 14/12/16.
 */
@Controller
@SessionAttributes("user")
public class UserController{

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public String listUsers(Model model) {
        model.addAttribute("userList", userService.getUserList());
        return "users";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/user/remove/{username}")
    public String removeUser(Model model, @PathVariable("username") String username) {

        userService.remove(username);
        return "redirect:/users";

    }


    @RequestMapping(method = RequestMethod.POST, value = "/user/add/{variable}")
    public String addUser(Model model, @ModelAttribute User user, RedirectAttributes redirectAttributes) {


        userService.addUser(user);
        redirectAttributes.addFlashAttribute("Successfully", "Added user " + user.getUsername() + " successfully!");
        return "redirect:/users";

    }

//falta um edit user
}
