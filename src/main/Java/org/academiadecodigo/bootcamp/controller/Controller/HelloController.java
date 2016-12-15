package org.academiadecodigo.bootcamp.controller.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by codecadet on 12/12/16.
 */
@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/")

    public String sayHello(Model model) {

        // Add an attribute to the request
        model.addAttribute("greetings", "Hello World");

        // Return the view name
        return "hello";

    }

}