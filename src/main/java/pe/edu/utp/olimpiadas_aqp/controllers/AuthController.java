package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.utp.olimpiadas_aqp.models.requests.AuthRequest;
import pe.edu.utp.olimpiadas_aqp.models.responses.AuthResponse;
import pe.edu.utp.olimpiadas_aqp.services.AuthServiceInterface;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthServiceInterface authService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }
}
