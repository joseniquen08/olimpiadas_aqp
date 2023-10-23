package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.UserEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.UserRequest;
import pe.edu.utp.olimpiadas_aqp.models.responses.UserResponse;
import pe.edu.utp.olimpiadas_aqp.repositories.UserRepository;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse create(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRequest, userEntity);
        userRepository.save(userEntity);
        UserResponse userToReturn = new UserResponse();
        BeanUtils.copyProperties(userEntity, userToReturn);
        return userToReturn;
    }
}
