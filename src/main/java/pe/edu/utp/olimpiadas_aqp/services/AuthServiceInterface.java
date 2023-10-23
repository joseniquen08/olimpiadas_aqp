package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.security.core.userdetails.UserDetails;
import pe.edu.utp.olimpiadas_aqp.models.requests.AuthRequest;
import pe.edu.utp.olimpiadas_aqp.models.responses.AuthResponse;

public interface AuthServiceInterface {
    AuthResponse login(AuthRequest authRequest);
}
