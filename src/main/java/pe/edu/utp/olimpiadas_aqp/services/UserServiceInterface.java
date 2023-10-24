package pe.edu.utp.olimpiadas_aqp.services;

import pe.edu.utp.olimpiadas_aqp.models.requests.AuthRequest;
import pe.edu.utp.olimpiadas_aqp.models.requests.UserClienteRequest;
import pe.edu.utp.olimpiadas_aqp.models.requests.UserRequest;
import pe.edu.utp.olimpiadas_aqp.models.responses.UserClientResponse;

public interface UserServiceInterface {
    UserClientResponse create(UserClienteRequest userClientRequest);
}
