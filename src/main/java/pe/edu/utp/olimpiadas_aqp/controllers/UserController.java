package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.olimpiadas_aqp.models.requests.ClientRequest;
import pe.edu.utp.olimpiadas_aqp.models.requests.DelegateRequest;
import pe.edu.utp.olimpiadas_aqp.models.responses.ClientResponse;
import pe.edu.utp.olimpiadas_aqp.models.responses.DelegateResponse;
import pe.edu.utp.olimpiadas_aqp.models.responses.UserResponse;
import pe.edu.utp.olimpiadas_aqp.services.UserServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceInterface userService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "create/client", method = RequestMethod.POST)
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest) {
        return userService.createClient(clientRequest);
    }

    @RequestMapping(value = "create/delegate", method = RequestMethod.POST)
    public DelegateResponse createDelegate(@RequestBody DelegateRequest delegateRequest) {
        return userService.createDelegate(delegateRequest);
    }
}
