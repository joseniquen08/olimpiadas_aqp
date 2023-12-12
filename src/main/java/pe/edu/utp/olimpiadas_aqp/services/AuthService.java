package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.ClientEntity;
import pe.edu.utp.olimpiadas_aqp.entities.DelegateEntity;
import pe.edu.utp.olimpiadas_aqp.entities.UserEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.auth.LoginReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.auth.LoginRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.GetUserRes;
import pe.edu.utp.olimpiadas_aqp.repositories.ClientRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.DelegateRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.UserRepository;
import pe.edu.utp.olimpiadas_aqp.security.JwtUtil;

@Service
public class AuthService implements AuthServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DelegateRepository delegateRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public LoginRes login(LoginReq loginReq) {
        UserEntity userEntity = userRepository.findByEmail(loginReq.getEmail());
        LoginRes response = new LoginRes();
        if (userEntity == null) {
            response.setStatus(400);
            response.setMessage("El usuario no existe.");
        } else {
            if (bCryptPasswordEncoder.matches(loginReq.getPassword(), userEntity.getPassword())) {
                response.setStatus(200);
                response.setMessage("Correcto.");
                GetUserRes user = new GetUserRes();
                BeanUtils.copyProperties(userEntity, user);
                user.setRoleName(userEntity.getRole().getName());
                if (userEntity.getRole().getName().equals("CLIENTE")) {
                    ClientEntity client = clientRepository.findByUserId(user.getUserId());
                    user.setUserRoleId(client.getClientId());
                } else if (userEntity.getRole().getName().equals("DELEGADO")) {
                    DelegateEntity delegate = delegateRepository.findByUserId(user.getUserId());
                    user.setUserRoleId(delegate.getDelegateId());
                }
                response.setUser(user);
                String token = jwtUtil.createToken(userEntity.getRole().getName());
                response.setToken(token);
            } else {
                response.setStatus(404);
                response.setMessage("Credenciales incorrectas.");
            }
        }
        return response;
    }
}
