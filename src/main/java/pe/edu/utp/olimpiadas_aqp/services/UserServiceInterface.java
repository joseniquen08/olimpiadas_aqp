package pe.edu.utp.olimpiadas_aqp.services;

import pe.edu.utp.olimpiadas_aqp.models.requests.ClientRequest;
import pe.edu.utp.olimpiadas_aqp.models.requests.DelegateRequest;
import pe.edu.utp.olimpiadas_aqp.models.responses.ClientResponse;
import pe.edu.utp.olimpiadas_aqp.models.responses.DelegateResponse;
import pe.edu.utp.olimpiadas_aqp.models.responses.UserResponse;

import java.util.List;

public interface UserServiceInterface {
    List<UserResponse> getAll();
    ClientResponse createClient(ClientRequest clientRequest);
    DelegateResponse createDelegate(DelegateRequest delegateRequest);
}
