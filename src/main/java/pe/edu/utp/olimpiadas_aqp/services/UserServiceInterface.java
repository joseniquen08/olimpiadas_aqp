package pe.edu.utp.olimpiadas_aqp.services;

import pe.edu.utp.olimpiadas_aqp.models.requests.ClientRequest;
import pe.edu.utp.olimpiadas_aqp.models.responses.ClientResponse;

public interface UserServiceInterface {
    ClientResponse create(ClientRequest clientRequest);
}
