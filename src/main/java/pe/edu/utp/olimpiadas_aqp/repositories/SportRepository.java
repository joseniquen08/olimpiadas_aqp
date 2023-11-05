package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.olimpiadas_aqp.entities.SportEntity;

@Repository
public interface SportRepository extends JpaRepository<SportEntity, Long> {
}
