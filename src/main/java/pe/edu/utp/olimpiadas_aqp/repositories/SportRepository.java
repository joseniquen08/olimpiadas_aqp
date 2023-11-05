package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.olimpiadas_aqp.entities.SportEntity;

import java.sql.Date;

@Repository
public interface SportRepository extends JpaRepository<SportEntity, Long> {
    @Transactional
    @Modifying
    @Query("update sport s set s.name = :name, s.description = :description where s.sportId = :sport_id")
    int editById(
            @Param("sport_id") Long sportId,
            @Param("name") String name,
            @Param("description") String description);
}
