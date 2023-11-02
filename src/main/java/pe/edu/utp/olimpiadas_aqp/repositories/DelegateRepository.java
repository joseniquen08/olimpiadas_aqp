package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.olimpiadas_aqp.entities.DelegateEntity;

@Repository
public interface DelegateRepository extends CrudRepository<DelegateEntity, Long> {
}
