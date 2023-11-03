package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.dto.ClientDTO;
import pe.edu.utp.olimpiadas_aqp.dto.DelegateDTO;
import pe.edu.utp.olimpiadas_aqp.entities.ClientEntity;
import pe.edu.utp.olimpiadas_aqp.entities.DelegateEntity;
import pe.edu.utp.olimpiadas_aqp.entities.RoleEntity;
import pe.edu.utp.olimpiadas_aqp.entities.UserEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.user.client.ClientReq;
import pe.edu.utp.olimpiadas_aqp.models.requests.user.delegate.DelegateReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.ClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.client.CreateClientRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.delegate.CreateDelegateRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.UserRes;
import pe.edu.utp.olimpiadas_aqp.repositories.ClientRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.DelegateRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DelegateRepository delegateRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserRes> getAll() {
        List<UserEntity> users = userRepository.findAll();
        List<UserRes> response = new ArrayList<>();
        for (UserEntity user: users) {
            UserRes userRes = new UserRes();
            BeanUtils.copyProperties(user, userRes);
            userRes.setRoleName(user.getRole().getName());
            response.add(userRes);
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
    public CreateClientRes createClient(ClientReq clientReq) {
        UserEntity userEntity = new UserEntity();
        RoleEntity roleEntity = new RoleEntity();
        ClientEntity clientEntity = new ClientEntity();
        ClientDTO clientDTO = new ClientDTO();
        CreateClientRes response = new CreateClientRes();

        roleEntity.setRoleId(clientReq.getRoleId());
        BeanUtils.copyProperties(clientReq, userEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(clientReq.getPassword()));
        userEntity.setRole(roleEntity);
        userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity, clientDTO);

        BeanUtils.copyProperties(clientReq, clientEntity);
        clientEntity.setUser(userEntity);
        clientRepository.save(clientEntity);
        BeanUtils.copyProperties(clientEntity, clientDTO);

        response.setMessage("Cliente creado correctamente.");
        response.setStatus(201);
        response.setUser(clientDTO);
        return response;
    }

    @Override
    public CreateDelegateRes createDelegate(DelegateReq delegateReq) {
        UserEntity userEntity = new UserEntity();
        RoleEntity roleEntity = new RoleEntity();
        DelegateEntity delegateEntity = new DelegateEntity();
        DelegateDTO delegateDTO = new DelegateDTO();
        CreateDelegateRes response = new CreateDelegateRes();

        roleEntity.setRoleId(delegateReq.getRoleId());
        BeanUtils.copyProperties(delegateReq, userEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(delegateReq.getPassword()));
        userEntity.setRole(roleEntity);
        userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity, delegateDTO);

        BeanUtils.copyProperties(delegateReq, delegateEntity);
        delegateEntity.setUser(userEntity);
        delegateRepository.save(delegateEntity);
        BeanUtils.copyProperties(delegateEntity, delegateDTO);

        response.setMessage("Delegado creado correctamente.");
        response.setStatus(201);
        response.setUser(delegateDTO);
        return response;
    }
}
