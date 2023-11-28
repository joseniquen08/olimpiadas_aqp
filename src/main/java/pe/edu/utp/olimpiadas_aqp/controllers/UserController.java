package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import pe.edu.utp.olimpiadas_aqp.models.requests.user.client.ClientReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.user.delegate.DelegateReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.BodyRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.DeleteUserRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.ClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.CreateClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.EditClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.CreateDelegateRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.UserRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.DelegateRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.EditDelegateRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.GetDelegatesByEventIdRes;
import pe.edu.utp.olimpiadas_aqp.services.UserServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceInterface userService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public BodyRes<List<UserRes>> getAll(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return userService.getAll(token);
    }

    @RequestMapping(value = "client/all", method = RequestMethod.GET)
    public List<ClientRes> getAllClient() {
        return userService.getAllClient();
    }

    @RequestMapping(value = "delegate/all", method = RequestMethod.GET)
    public List<DelegateRes> getAllDelegate() {
        return userService.getAllDelegate();
    }

    @RequestMapping(value = "delegate/all/event/{id}", method = RequestMethod.GET)
    public GetDelegatesByEventIdRes getDelegatesByEventId(@PathVariable("id") Long eventId) {
        return userService.getDelegatesByEventId(eventId);
    }

    @RequestMapping(value = "create/client", method = RequestMethod.POST)
    public CreateClientRes createClient(@RequestBody ClientReq clientReq) {
        return userService.createClient(clientReq);
    }

    @RequestMapping(value = "create/delegate", method = RequestMethod.POST)
    public CreateDelegateRes createDelegate(@RequestBody DelegateReq delegateReq) {
        return userService.createDelegate(delegateReq);
    }

    @RequestMapping(value = "edit/client/{id}", method = RequestMethod.PUT)
    public EditClientRes editClientById(@PathVariable("id") Long clientId, @RequestBody ClientReq clientReq) {
        return userService.editClientById(clientId, clientReq);
    }

    @RequestMapping(value = "edit/delegate/{id}", method = RequestMethod.PUT)
    public EditDelegateRes editDelegateById(@PathVariable("id") Long delegateId, @RequestBody DelegateReq delegateReq) {
        return userService.editDelegateById(delegateId, delegateReq);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public DeleteUserRes deleteUserById(@PathVariable("id") Long userId) {
        return userService.deleteUserById(userId);
    }
}
