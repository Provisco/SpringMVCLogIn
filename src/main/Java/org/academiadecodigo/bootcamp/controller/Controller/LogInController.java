package org.academiadecodigo.bootcamp.controller.Controller;

import org.academiadecodigo.bootcamp.controller.Model.MockUserService;
import org.academiadecodigo.bootcamp.controller.Model.User;
import org.academiadecodigo.bootcamp.controller.Model.UserService;
import org.academiadecodigo.bootcamp.controller.authenticate.Authenticator;
import org.springframework.asm.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by codecadet on 13/12/16.
 */
@Controller
@SessionAttributes ("user")
public class LogInController {

    @Autowired
    private Authenticator authenticator;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView showLogin() {

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());
        return modelAndView;

    }


    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String doLogin(Model model, @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        // If user/pass fields are empty, display the same view again
        if (user.getUsername() == null || user.getUsername().isEmpty() || user.getPassword() == null || user.getPassword().isEmpty()) {
            return "login";
        }

        // If auth succeeds, render a new view
        if (authenticator.authenticate(user.getUsername(), user.getPassword())) {
            model.addAttribute("greeting", "Welcome");
            model.addAttribute("userList", userService.getUserList());
            return "mainpage";

            // If auth fails, render the same view with error message
        } else {
            model.addAttribute("error", "Authentication Failure");
            return "login";
        }
    }




}
