package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login() {
        return "Login";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register() {
        return "Register";
    }
}
