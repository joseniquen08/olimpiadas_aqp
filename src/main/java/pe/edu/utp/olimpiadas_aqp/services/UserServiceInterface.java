package pe.edu.utp.olimpiadas_aqp.services;

import pe.edu.utp.olimpiadas_aqp.models.requests.user.client.ClientReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.user.delegate.DelegateReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.BodyRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.DeleteEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.DeleteUserRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.ClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.CreateClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.EditClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.CreateDelegateRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.UserRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.DelegateRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.EditDelegateRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.GetDelegatesByEventIdRes;

import java.util.List;

public interface UserServiceInterface {
    BodyRes<List<UserRes>> getAll(String token);
    List<ClientRes> getAllClient();
    List<DelegateRes> getAllDelegate();
//    GetDelegatesByEventIdRes getDelegatesBySportEventId(Long sportEventId);
    CreateClientRes createClient(ClientReq clientReq);
    CreateDelegateRes createDelegate(DelegateReq delegateReq);
    EditClientRes editClientById(Long clientId, ClientReq clientReq);
    EditDelegateRes editDelegateById(Long delegateId, DelegateReq delegateReq);
    DeleteUserRes deleteUserById(Long userId);
}
