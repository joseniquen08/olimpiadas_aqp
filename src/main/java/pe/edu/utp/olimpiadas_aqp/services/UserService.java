package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.olimpiadas_aqp.entities.UserClientEntity;
import pe.edu.utp.olimpiadas_aqp.entities.UserEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.UserClienteRequest;
import pe.edu.utp.olimpiadas_aqp.models.requests.UserRequest;
import pe.edu.utp.olimpiadas_aqp.models.responses.UserClientResponse;
import pe.edu.utp.olimpiadas_aqp.repositories.UserClientRepository;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserClientRepository userClientRepository;

    @Override
    public UserClientResponse create(UserClienteRequest userClientRequest) {
        UserClientEntity userClientEntity = new UserClientEntity();
        BeanUtils.copyProperties(userClientRequest, userClientEntity);
        userClientRepository.save(userClientEntity);
        UserClientResponse userClientToReturn= new UserClientResponse();
        BeanUtils.copyProperties(userClientEntity, userClientToReturn);
        return userClientToReturn;
    }
}
