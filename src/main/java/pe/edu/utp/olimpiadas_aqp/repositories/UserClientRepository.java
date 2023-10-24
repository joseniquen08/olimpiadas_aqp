package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.olimpiadas_aqp.entities.UserClientEntity;

@Repository
public interface UserClientRepository extends CrudRepository<UserClientEntity, Long> {
    
}