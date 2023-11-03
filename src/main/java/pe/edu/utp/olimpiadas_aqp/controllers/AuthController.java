package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.olimpiadas_aqp.models.requests.auth.LoginReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.auth.LoginRes;
import pe.edu.utp.olimpiadas_aqp.services.AuthServiceInterface;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthServiceInterface authService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginRes login(@RequestBody LoginReq loginReq) {
        return authService.login(loginReq);
    }
}
