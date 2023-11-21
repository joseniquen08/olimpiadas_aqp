package pe.edu.utp.olimpiadas_aqp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.olimpiadas_aqp.entities.TeamEntity;

import java.sql.Date;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    @Transactional
    @Modifying
    @Query("update team s set s.name = :name, s.urlImagen = :urlImagen where s.teamId = :team_id")
    int editById(
            @Param("team_id") Long teamId,
            @Param("name") String name,
            @Param("urlImagen") String urlImagen);
    
}
