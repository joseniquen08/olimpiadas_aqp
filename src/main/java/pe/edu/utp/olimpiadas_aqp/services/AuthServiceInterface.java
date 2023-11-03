package pe.edu.utp.olimpiadas_aqp.services;

import pe.edu.utp.olimpiadas_aqp.models.requests.auth.LoginReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.auth.LoginRes;

public interface AuthServiceInterface {
    LoginRes login(LoginReq loginReq);
}
