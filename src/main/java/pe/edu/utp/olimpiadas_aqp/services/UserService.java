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
import pe.edu.utp.olimpiadas_aqp.models.requests.ClientRequest;
import pe.edu.utp.olimpiadas_aqp.models.requests.DelegateRequest;
import pe.edu.utp.olimpiadas_aqp.models.responses.ClientResponse;
import pe.edu.utp.olimpiadas_aqp.models.responses.DelegateResponse;
import pe.edu.utp.olimpiadas_aqp.models.responses.UserResponse;
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
    public List<UserResponse> getAll() {
        List<UserEntity> users = userRepository.findAll();
        List<UserResponse> response = new ArrayList<>();
        for (UserEntity user: users) {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            userResponse.setRoleName(user.getRole().getName());
            response.add(userResponse);
        }
        return response;
    }

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        UserEntity userEntity = new UserEntity();
        RoleEntity roleEntity = new RoleEntity();
        ClientEntity clientEntity = new ClientEntity();
        ClientDTO clientDTO = new ClientDTO();
        ClientResponse response = new ClientResponse();

        roleEntity.setRoleId(clientRequest.getRoleId());
        BeanUtils.copyProperties(clientRequest, userEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(clientRequest.getPassword()));
        userEntity.setRole(roleEntity);
        userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity, clientDTO);

        BeanUtils.copyProperties(clientRequest, clientEntity);
        clientEntity.setUser(userEntity);
        clientRepository.save(clientEntity);
        BeanUtils.copyProperties(clientEntity, clientDTO);

        response.setMessage("Cliente creado correctamente.");
        response.setStatus(201);
        response.setUser(clientDTO);
        return response;
    }

    @Override
    public DelegateResponse createDelegate(DelegateRequest delegateRequest) {
        UserEntity userEntity = new UserEntity();
        RoleEntity roleEntity = new RoleEntity();
        DelegateEntity delegateEntity = new DelegateEntity();
        DelegateDTO delegateDTO = new DelegateDTO();
        DelegateResponse response = new DelegateResponse();

        roleEntity.setRoleId(delegateRequest.getRoleId());
        BeanUtils.copyProperties(delegateRequest, userEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(delegateRequest.getPassword()));
        userEntity.setRole(roleEntity);
        userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity, delegateDTO);

        BeanUtils.copyProperties(delegateRequest, delegateEntity);
        delegateEntity.setUser(userEntity);
        delegateRepository.save(delegateEntity);
        BeanUtils.copyProperties(delegateEntity, delegateDTO);

        response.setMessage("Delegado creado correctamente.");
        response.setStatus(201);
        response.setUser(delegateDTO);
        return response;
    }
}
