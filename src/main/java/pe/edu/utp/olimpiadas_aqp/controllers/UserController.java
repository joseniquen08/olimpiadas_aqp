package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.olimpiadas_aqp.models.requests.UserClienteRequest;
import pe.edu.utp.olimpiadas_aqp.models.requests.UserRequest;
import pe.edu.utp.olimpiadas_aqp.models.responses.UserClientResponse;
import pe.edu.utp.olimpiadas_aqp.services.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceInterface userService;

    @RequestMapping(value="create/Cliente", method = RequestMethod.POST)
    public UserClientResponse createClient(@RequestBody UserClienteRequest userClientRequest) {
        return userService.create(userClientRequest);
    }
    
}
