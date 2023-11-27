package pe.edu.utp.olimpiadas_aqp.services;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.UserEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.auth.LoginReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.auth.LoginRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.user.GetUserRes;
import pe.edu.utp.olimpiadas_aqp.repositories.UserRepository;
import pe.edu.utp.olimpiadas_aqp.security.SecurityConstants;

import java.security.Key;
import java.util.Date;

@Service
public class AuthService implements AuthServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

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
                response.setUser(user);
                Key key = Jwts.SIG.HS512.key().build();
                String token = Jwts.builder()
                        .subject(userEntity.getEmail())
                        .expiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_DATE))
                        .signWith(key)
                        .compact();
                response.setToken(SecurityConstants.TOKEN_PREFIX + token);
            } else {
                response.setStatus(404);
                response.setMessage("Credenciales incorrectas.");
            }
        }
        return response;
    }
}
