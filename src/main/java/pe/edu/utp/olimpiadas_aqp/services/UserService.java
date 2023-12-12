package pe.edu.utp.olimpiadas_aqp.services;

import io.jsonwebtoken.JwtException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.*;
import pe.edu.utp.olimpiadas_aqp.models.requests.user.client.ClientReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.user.delegate.DelegateReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.BodyRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.DeleteUserRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.ClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.CreateClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.EditClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.GetClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.*;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.UserRes;
import pe.edu.utp.olimpiadas_aqp.repositories.*;
import pe.edu.utp.olimpiadas_aqp.security.JwtUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DelegateRepository delegateRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public BodyRes<List<UserRes>> getAll(String token) {
        BodyRes<List<UserRes>> response = new BodyRes<>();
        try {
            List<UserRes> userResList = new ArrayList<>();
            boolean isValid = jwtUtil.validateToken(token).equals("ADMIN");
            if (isValid) {
                List<UserEntity> users = userRepository.findAll();
                for (UserEntity user: users) {
                    UserRes userRes = new UserRes();
                    BeanUtils.copyProperties(user, userRes);
                    userRes.setRoleName(user.getRole().getName());
                    if (user.getRole().getName().equals("CLIENTE")) {
                        GetClientRes clientRes = new GetClientRes();
                        ClientEntity client = clientRepository.findByUserId(user.getUserId());
                        BeanUtils.copyProperties(client, clientRes);
                        userRes.setClient(clientRes);
                    } else if (user.getRole().getName().equals("DELEGADO")) {
                        GetDelegateRes delegateRes = new GetDelegateRes();
                        DelegateEntity delegate = delegateRepository.findByUserId(user.getUserId());
                        BeanUtils.copyProperties(delegate, delegateRes);
                        userRes.setDelegate(delegateRes);
                    }
                    userResList.add(userRes);
                }
                response.setData(userResList);
            }
        } catch (JwtException e) {
            response.setStatus(HttpStatus.UNAUTHORIZED);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public List<ClientRes> getAllClient() {
        List<ClientEntity> clients = clientRepository.findAll();
        List<ClientRes> response = new ArrayList<>();
        for (ClientEntity client: clients) {
            ClientRes clientRes = new ClientRes();
            clientRes.setClientId(client.getClientId());
            clientRes.setFullName(client.getUser().getFullName());
            response.add(clientRes);
        }
        return response;
    }

    @Override
    public List<DelegateRes> getAllDelegate() {
        List<DelegateEntity> delegates = delegateRepository.findAll();
        List<DelegateRes> response = new ArrayList<>();
        for (DelegateEntity delegate: delegates) {
            DelegateRes delegateRes = new DelegateRes();
            delegateRes.setDelegateId(delegate.getDelegateId());
            delegateRes.setFullName(delegate.getUser().getFullName());
            response.add(delegateRes);
        }
        return response;
    }

//    @Override
//    public GetDelegatesByEventIdRes getDelegatesBySportEventId(Long sportEventId) {
//        List<DelegateEventEntity> delegatesEvent = delegateEventRepository.findByEventId(eventId);
//        GetDelegatesByEventIdRes response = new GetDelegatesByEventIdRes();
//        List<GetDelegatesEventRes> delegates = new ArrayList<>();
//        for (DelegateEventEntity delegateEvent: delegatesEvent) {
//            GetDelegatesEventRes delegatesEventRes = new GetDelegatesEventRes();
//            BeanUtils.copyProperties(delegateEvent.getDelegate().getUser(), delegatesEventRes);
//            BeanUtils.copyProperties(delegateEvent.getDelegate(), delegatesEventRes);
//            delegatesEventRes.setDelegateEventId(delegateEvent.getDelegateEventId());
//            delegates.add(delegatesEventRes);
//        }
//        response.setDelegates(delegates);
//        EventEntity eventEntity;
//        Optional<EventEntity> findByIdRes = eventRepository.findById(eventId);
//        if (findByIdRes.isPresent()) {
//            eventEntity = findByIdRes.get();
//            response.setEventName(eventEntity.getName());
//        }
//        return response;
//    }

    @Override
    public CreateClientRes createClient(ClientReq clientReq) {
        UserEntity userEntity = new UserEntity();
        RoleEntity roleEntity = new RoleEntity();
        ClientEntity clientEntity = new ClientEntity();
        CreateClientRes response = new CreateClientRes();

        roleEntity.setRoleId(clientReq.getRoleId());
        BeanUtils.copyProperties(clientReq, userEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(clientReq.getPassword()));
        userEntity.setRole(roleEntity);
        userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity, response);

        BeanUtils.copyProperties(clientReq, clientEntity);
        clientEntity.setUser(userEntity);
        clientRepository.save(clientEntity);
        BeanUtils.copyProperties(clientEntity, response);

        response.setMessage("Cliente creado correctamente.");
        response.setStatus(201);
        return response;
    }

    @Override
    public CreateDelegateRes createDelegate(DelegateReq delegateReq) {
        UserEntity userEntity = new UserEntity();
        RoleEntity roleEntity = new RoleEntity();
        DelegateEntity delegateEntity = new DelegateEntity();
        CreateDelegateRes response = new CreateDelegateRes();

        roleEntity.setRoleId(delegateReq.getRoleId());
        BeanUtils.copyProperties(delegateReq, userEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(delegateReq.getPassword()));
        userEntity.setRole(roleEntity);
        userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity, response);

        BeanUtils.copyProperties(delegateReq, delegateEntity);
        delegateEntity.setUser(userEntity);
        delegateRepository.save(delegateEntity);
        BeanUtils.copyProperties(delegateEntity, response);

        response.setMessage("Delegado creado correctamente.");
        response.setStatus(201);
        return response;
    }

    @Override
    public EditClientRes editClientById(Long clientId, ClientReq clientReq) {
        EditClientRes response = new EditClientRes();
        ClientEntity clientEntity;
        int isClientCorrect = clientRepository.editClientById(
                clientId,
                clientReq.getPhone(),
                clientReq.getRepresentative());
        if (isClientCorrect == 1) {
            Optional<ClientEntity> findByIdRes = clientRepository.findById(clientId);
            if (findByIdRes.isPresent()) {
                clientEntity = findByIdRes.get();
                int isUserCorrect = userRepository.editUserById(
                        clientEntity.getUser().getUserId(),
                        clientReq.getFullName());
                if (isUserCorrect == 1) {
                    response.setStatus(204);
                    response.setMessage("Datos del cliente editados correctamente.");
                    return response;
                }
            }
        }
        response.setStatus(400);
        response.setMessage("Error.");
        return response;
    }

    @Override
    public EditDelegateRes editDelegateById(Long delegateId, DelegateReq delegateReq) {
        EditDelegateRes response = new EditDelegateRes();
        DelegateEntity delegateEntity;
        int isDelegateCorrect = delegateRepository.editDelegateById(
                delegateId,
                delegateReq.getPhone());
        if (isDelegateCorrect == 1) {
            Optional<DelegateEntity> findByIdRes = delegateRepository.findById(delegateId);
            if (findByIdRes.isPresent()) {
                delegateEntity = findByIdRes.get();
                int isUserCorrect = userRepository.editUserById(
                        delegateEntity.getUser().getUserId(),
                        delegateReq.getFullName());
                if (isUserCorrect == 1) {
                    response.setStatus(204);
                    response.setMessage("Datos del cliente editados correctamente.");
                    return response;
                }
            }
        }
        response.setStatus(400);
        response.setMessage("Error.");
        return response;
    }

    @Override
    public DeleteUserRes deleteUserById(Long userId) {
        DeleteUserRes response = new DeleteUserRes();
        Optional<UserEntity> findByIdRes = userRepository.findById(userId);
        if (findByIdRes.isPresent()) {
            UserEntity user = findByIdRes.get();
            Long roleId = user.getRole().getRoleId();
            if (roleId == 2) {
                ClientEntity client = clientRepository.findByUserId(userId);
                clientRepository.deleteById(client.getClientId());
                userRepository.deleteById(userId);
                response.setStatus(204);
                response.setMessage("Eliminado correctamente.");
                return response;
            } else if (roleId == 3) {
                DelegateEntity delegate = delegateRepository.findByUserId(userId);
                delegateRepository.deleteById(delegate.getDelegateId());
                userRepository.deleteById(userId);
                response.setStatus(204);
                response.setMessage("Eliminado correctamente.");
                return response;
            }
        }
        response.setStatus(400);
        response.setMessage("Error.");
        return response;
    }
}
