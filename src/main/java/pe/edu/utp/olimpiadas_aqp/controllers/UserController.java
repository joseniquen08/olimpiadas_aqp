package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="all", method = RequestMethod.GET)
    public String getUsers() {
        return "Lista de usuarios";
    }

    @RequestMapping(value="create", method = RequestMethod.POST)
    public String create() {
        return "Creacion ded usuario";
    }
}
