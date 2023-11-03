package pe.edu.utp.olimpiadas_aqp.services;

import pe.edu.utp.olimpiadas_aqp.models.requests.user.client.ClientReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.user.delegate.DelegateReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.ClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.CreateClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.CreateDelegateRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.UserRes;

import java.util.List;

public interface UserServiceInterface {
    List<UserRes> getAll();
    List<ClientRes> getAllClient();
    CreateClientRes createClient(ClientReq clientReq);
    CreateDelegateRes createDelegate(DelegateReq delegateReq);
}
